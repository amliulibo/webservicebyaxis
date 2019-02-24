package demo.demo1;

import java.util.ArrayList;
import java.util.List;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;

public class AMQQueueConsumer {
	
	
	
	private  String BROKER_URL="tcp://localhost:61616";
	private Connection connection=null; 
	private Session session;
	private Queue queue;
	public Queue getQueue() {
		return queue;
	}
	public void setQueue(Queue queue) {
		this.queue = queue;
	}
	//private MessageProducer producer;
	private MessageListener messageListener;
	public AMQQueueConsumer(String queueName,String broker) throws JMSException
	{
		BROKER_URL=broker;
		 //1、创建工厂连接对象，需要制定ip和端口号
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        //2、使用连接工厂创建一个连接对象
         connection = connectionFactory.createConnection();
        //3、开启连接
        connection.start();
      //4、使用连接对象创建会话（session）对象
        //此方法第一个参数表示会话是否在事务中执行，第二个参数设定会话的应答模式

        //第一个参数:是否支持事务，如果为true，则会忽略第二个参数，被jms服务器设置为SESSION_TRANSACTED
        //第二个参数为false时，paramB的值可为Session.AUTO_ACKNOWLEDGE，Session.CLIENT_ACKNOWLEDGE，DUPS_OK_ACKNOWLEDGE其中一个。
        //Session.AUTO_ACKNOWLEDGE为自动确认，客户端发送和接收消息不需要做额外的工作。哪怕是接收端发生异常，也会被当作正常发送成功。
        //Session.CLIENT_ACKNOWLEDGE为客户端确认。客户端接收到消息后，必须调用javax.jms.Message的acknowledge方法。jms服务器才会当作发送成功，并删除消息。
        //DUPS_OK_ACKNOWLEDGE允许副本的确认模式。一旦接收方应用程序的方法调用从处理消息处返回，会话对象就会确认消息的接收；而且允许重复确认。
         session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        //5、使用会话对象创建目标对象，包含queue或topic（一对一或一对多）
        queue = session.createQueue(queueName);
        //createConsumer();
       
         
	}
	public AMQQueueConsumer(String queueName,String broker,MessageListener messageListener) throws JMSException
	{
		
		this(queueName,broker);
		this.messageListener=messageListener;
		//createConsumer();
	
	}
	private void createConsumer() throws JMSException {
		//6、创建消费者对象
		     MessageConsumer consumer = session.createConsumer(queue);
		   //7、向consumer对象中设置一个messageListener对象，用来接收消息
		     
		     if (messageListener!=null) {
		    	 consumer.setMessageListener(messageListener);
			}else {
				consumer.setMessageListener(new MessageListener() {

					         @Override
					         public void onMessage(Message message) {
					             // TODO Auto-generated method stub
					             if(message instanceof TextMessage){
					                 TextMessage textMessage = (TextMessage)message;
					               
					                 
					                 try {
					                	//确认接收，并成功处理了消息
					                	 message.acknowledge();
					                     System.out.println("<<<<<<<<接收到消息:name="+queue.getQueueName()+"msg="+ textMessage.getText());
					                 } catch (JMSException e) {
					                     // TODO Auto-generated catch block
					                     e.printStackTrace();
					                 }
					             }
					         }
					     });
			}
		     
		     
		     
	}
	
	public void Start() throws JMSException
	{
		createConsumer();
		
	}
	
	public List<String> getTextMessage(int count) throws JMSException
	{
		List<String> list=new ArrayList<>();
		MessageConsumer consumer = session.createConsumer(queue);
		for (int i = 0; i < count; i++) {
			//Message message= consumer.receive(1000);
			//Message message= consumer.receive(1);
			Message message= consumer.receiveNoWait();
			if (message!=null) {
				list.add(((TextMessage)message).getText());
				message.acknowledge();
			}
		}
		return list;
	}
	
	 
 
	public void close() throws JMSException
	{
		 //9、关闭资源
        //producer.close();
        session.close();
        connection.close();
	}
	public MessageListener getMessageListener() {
		return messageListener;
	}
	public void setMessageListener(MessageListener messageListener) {
		this.messageListener = messageListener;
	}
	
	
	 
}
