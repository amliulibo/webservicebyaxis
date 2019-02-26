package demo2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import helper.LogHelper;

public class NewTask {

	private final static String QUEUE_NAME="QUEUE2";
	public static void main(String[] args) {
		ConnectionFactory factory=new ConnectionFactory();
		factory.setHost("localhost");
		try ( Connection connection=factory.newConnection();
			   Channel channel=connection.createChannel()) {
			
			channel.queueDeclare(QUEUE_NAME,false,false,false,null );
			//String message=String.join("-", args);// "hello world";
			//channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			
			args = new String[]{"first message.","second message.","thrid message.","fourth message.","fifth message.",};
			
			for (int i = 0; i < args.length; i++) {
				String s1= args[i];
				channel.basicPublish("", QUEUE_NAME, null, s1.getBytes());
				LogHelper.debug("sent "+s1);
			}
			
			
			//LogHelper.debug("[X] sent "+message);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
