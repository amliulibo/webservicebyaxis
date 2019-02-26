package demo1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import helper.LogHelper;

public class Send {
	private final static String QUEUE_NAME="QUEUQ1";
	public static void main(String[] args) {
		ConnectionFactory factory=new ConnectionFactory();
		factory.setHost("localhost");
		try ( Connection connection=factory.newConnection();
			   Channel channel=connection.createChannel()) {
			
			channel.queueDeclare(QUEUE_NAME,false,false,false,null );
			String message="hello world";
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			//System.out.println("[X] sent "+message);
			
			LogHelper.debug("[X] sent "+message);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
