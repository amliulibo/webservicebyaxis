package demo3;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import helper.LogHelper;

public class ReceiveLogs {
	private final static String EXCHANGE_NAME="logs";

	public static void main(String[] args) {
		ConnectionFactory factory=new ConnectionFactory();
		factory.setHost("localhost");
		try ( Connection connection=factory.newConnection();
				   Channel channel=connection.createChannel()) 
			{
			
			channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
			String queueName=channel.queueDeclare().getQueue();
			channel.queueBind(queueName, EXCHANGE_NAME, "");
			
			LogHelper.debug("[*] Waiting for messages.To exit press CTRL+C");
			
			DeliverCallback deliverCallback=(consumerTag,delivery)->
			{
				String message=new String(delivery.getBody(),"UTF-8");
				LogHelper.debug("[X] Received "+message);
			};
			
			channel.basicConsume(queueName, true,deliverCallback,consumeTag->{});
			
			}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
}
