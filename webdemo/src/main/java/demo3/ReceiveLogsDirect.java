package demo3;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import helper.LogHelper;

public class ReceiveLogsDirect {
	private static final String EXCHANGE_NAME = "direct_logs";
	public static void main(String[] args) throws IOException, TimeoutException {
		// TODO Auto-generated method stub
		ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();
	    
	    channel.exchangeDeclare(EXCHANGE_NAME, "direct");
	    String queueName=channel.queueDeclare().getQueue();
	    
	    
	    if (args.length < 1) {
            System.err.println("Usage: ReceiveLogsDirect [info] [warning] [error]");
            System.exit(1);
        }
	    for (String severity : args) {
            channel.queueBind(queueName, EXCHANGE_NAME, severity);
        }
	    
	    
	    LogHelper.debug("[*] waiting for message.To exit press ^C");
	    
	    DeliverCallback deliverCallback=(consumertag,delivery)->{
	    	String message=new String(delivery.getBody());
	    	LogHelper.debug("[x] received"+delivery.getEnvelope().getRoutingKey()+"':'"+message+"'");
	    };
	    
	    channel.basicConsume(queueName,true, deliverCallback,consumetag->{});
	}

}
