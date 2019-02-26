package demo2;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import helper.LogHelper;

public class Worker
{

	private final static String QUEUE_NAME="QUEUE2";
	public static void main(String[] args) throws IOException, TimeoutException {
		// TODO Auto-generated method stub
		ConnectionFactory factory=new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection=factory.newConnection();
		Channel channel=connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		channel.basicQos(1);// accept only one unack-ed message at a time (see below)
		LogHelper.debug("[x] waiting for message,To exit press CTRL+C");
		
		DeliverCallback deliverCallback=(consumerTag,delivery)->{
			String message=new String(delivery.getBody(),"UTF-8");
			
			try {
				doWork(message);
			} catch (Exception e) {
				// TODO: handle exception
			}
			finally {
				LogHelper.debug("[x]done "+message);
				channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
			}
			
			LogHelper.debug("received "+message);
		};
		
		
		boolean autoAck=false;
		channel.basicConsume(QUEUE_NAME, autoAck,deliverCallback,consumerTag->{});
		
	}
	private static void doWork(String task) throws InterruptedException
	{
		for (char ch : task.toCharArray()) {
			if (ch=='.') {
				Thread.sleep(1000);
			}
		}
	}


}