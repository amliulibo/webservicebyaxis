package RPC;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class RPCServer {
	private static final String RPC_QUEUE_NAME = "rpc_queue";

	public static void main(String[] args) throws IOException, TimeoutException {
		// TODO Auto-generated method stub
		 ConnectionFactory factory = new ConnectionFactory();
	        factory.setHost("localhost");

	        try (Connection connection = factory.newConnection();
	             Channel channel = connection.createChannel()) {
	        	channel.queueDeclare(RPC_QUEUE_NAME, false, false, false, null);
	        	channel.queuePurge(RPC_QUEUE_NAME);
	        	
	        	channel.basicQos(1);
	        	System.out.println(" [x] Awaiting RPC requests");

	        	Object monitor=new Object();
	        	
	        	DeliverCallback deliverCallback=(consumeTag,delivery)->{
	        		AMQP.BasicProperties replyProps=new AMQP.BasicProperties
	        				.Builder()
	        				.correlationId(delivery.getProperties().getCorrelationId())
	        				.build();
	        		String response="";
	        		try {
						String message=new String(delivery.getBody());
						int n=Integer.parseInt(message);
						System.out.println(" [.] fib(" + message + ")");
	                    response += fib(n);
								
					} catch (RuntimeException e) {
						// TODO: handle exception
						System.out.println(" [.] " + e.toString());
					}finally {
						channel.basicPublish("", delivery.getProperties().getReplyTo(), replyProps, response.getBytes("UTF-8"));
	                    channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
	                 // RabbitMq consumer worker thread notifies the RPC server owner thread
	                    synchronized (monitor) {
							monitor.notify();
						}
					}
	        	};
	        	
	        	channel.basicConsume(RPC_QUEUE_NAME, false, deliverCallback, (consumerTag -> { }));
	            // Wait and be prepared to consume the message from RPC client.
	        	while (true) {
					synchronized (monitor) {
						try {
							monitor.wait();
						} catch (Exception e2) {
							// TODO: handle exception
							e2.printStackTrace();
						}
					}
				}
	        	
	        }
	}
	
	
    private static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

}
