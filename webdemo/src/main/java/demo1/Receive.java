package demo1;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Receive {

	private final static String QUEUE_NAME="QUEUQ1";
	public static void main(String[] args) throws IOException, TimeoutException {
		// TODO Auto-generated method stub
		ConnectionFactory factory=new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection=factory.newConnection();
		Channel channel=connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		
		System.out.println("[*] waiting for message,To exit press CTRL+C");
		DeliverCallback deliverCallback=(consumerTag,delivery)->{
			String message=new String(delivery.getBody(),"UTF-8");
			System.out.println("[X] received"+message);
		};
		channel.basicConsume(QUEUE_NAME, true,deliverCallback,consumerTag->{});
		
	}

}
