package demo3;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import helper.LogHelper;

public class EmitLog {

private final static String EXCHANGE_NAME="logs";
	
	public static void main(String[] args) {
		ConnectionFactory factory=new ConnectionFactory();
		factory.setHost("localhost");
		try ( Connection connection=factory.newConnection();
			   Channel channel=connection.createChannel()) 
		{
			 
			channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
		
			args =new String[]{"first message.","second message.","thrid message.","fourth message.","fifth message."};
			 
			String message=args.length<1?"info:Hello World!":String.join(" ", args);

			channel.basicPublish(EXCHANGE_NAME,"",null,message.getBytes());
			
			
			LogHelper.debug("[X] sent "+message);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
