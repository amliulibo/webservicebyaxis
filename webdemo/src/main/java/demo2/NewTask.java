package demo2;

import com.rabbitmq.client.AMQP.Queue.DeclareOk;
import com.rabbitmq.client.AMQP.Queue.DeleteOk;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import helper.LogHelper;

public class NewTask {

	private final static String QUEUE_NAME="QUEUE2";
	
	public static void main(String[] args) {
		ConnectionFactory factory=new ConnectionFactory();
		factory.setHost("localhost");
		try ( Connection connection=factory.newConnection();
			   Channel channel=connection.createChannel()) 
		{
			
			//DeclareOk ok= channel.queueDeclarePassive(QUEUE_NAME);
			//DeleteOk result= channel.queueDelete(QUEUE_NAME);
			
			boolean durable=true;
			channel.queueDeclare(QUEUE_NAME,durable,false,false,null );
		
			args =new String[]{"first message.","second message.","thrid message.","fourth message.","fifth message."};
			 
			for (int i = 0; i < args.length; i++) {
				String s1= args[i];
				channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, s1.getBytes("UTF-8"));
				LogHelper.debug("sent "+s1);
			}
			
			
			//LogHelper.debug("[X] sent "+message);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
