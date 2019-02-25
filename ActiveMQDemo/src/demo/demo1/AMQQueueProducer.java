package demo.demo1;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;

public class AMQQueueProducer {
	
	
	
	private  String BROKER_URL="tcp://localhost:61616";
	private Connection connection=null; 
	private Session session;
	private MessageProducer producer;
	public AMQQueueProducer(String queueName,String broker) throws JMSException
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
         session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5、使用会话对象创建目标对象，包含queue或topic（一对一或一对多）
        Queue queue = session.createQueue(queueName);
      //6、创建消息生产者对象
         producer = session.createProducer(queue);
         
       //设置生产者的模式，有两种可选
         //DeliveryMode.PERSISTENT 当activemq关闭的时候，队列数据将会被保存
         //DeliveryMode.NON_PERSISTENT 当activemq关闭的时候，队列里面的数据将会被清空
         producer.setDeliveryMode(DeliveryMode.PERSISTENT);
      
         
	}

 
	
	
	public void sendQueueMsg(String msg) throws Exception{
        
        
        
        //7、使用会话对象创建一个消息对象
        TextMessage textMessage = session.createTextMessage(msg);
        //8、发送消息
        System.out.println(">>>>>>>>>>我发送的消息是:"+textMessage.getText());
        producer.send(textMessage);
        
       
    }
	
	public void close() throws JMSException
	{
		 //9、关闭资源
        producer.close();
        session.close();
        connection.close();
	}
	
	
	
	 public void TopicProducer() throws Exception{
	        //1、创建工厂连接对象，需要制定ip和端口号
	        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
	        //2、使用连接工厂创建一个连接对象
	        Connection connection = connectionFactory.createConnection();
	        //3、开启连接
	        connection.start();
	        //4、使用连接对象创建会话（session）对象
	        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        //5、使用会话对象创建目标对象，包含queue和topic（一对一和一对多）
	        Topic topic = session.createTopic("test-topic");
	        //6、使用会话对象创建生产者对象
	        MessageProducer producer = session.createProducer(topic);
	        //7、使用会话对象创建一个消息对象
	        TextMessage textMessage = session.createTextMessage("hello!test-topic");
	        //8、发送消息
	        producer.send(textMessage);
	        //9、关闭资源
	        producer.close();
	        session.close();
	        connection.close();
	    }
	 
	 public void TopicConsumer() throws Exception{
	        //1、创建工厂连接对象，需要制定ip和端口号
	        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
	        //2、使用连接工厂创建一个连接对象
	        Connection connection = connectionFactory.createConnection();
	        //3、开启连接
	        connection.start();
	        //4、使用连接对象创建会话（session）对象
	        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        //5、使用会话对象创建目标对象，包含queue和topic（一对一和一对多）
	        Topic topic = session.createTopic("test-topic");
	        //6、使用会话对象创建生产者对象
	        MessageConsumer consumer = session.createConsumer(topic);
	        //7、向consumer对象中设置一个messageListener对象，用来接收消息
	        consumer.setMessageListener(new MessageListener() {

	            @Override
	            public void onMessage(Message message) {
	                // TODO Auto-generated method stub
	                if(message instanceof TextMessage){
	                    TextMessage textMessage = (TextMessage)message;
	                    try {
	                        System.out.println(textMessage.getText());
	                    } catch (JMSException e) {
	                        // TODO Auto-generated catch block
	                        e.printStackTrace();
	                    }
	                }
	            }
	        });
	        //8、程序等待接收用户消息
	        System.in.read();
	        //9、关闭资源
	        consumer.close();
	        session.close();
	        connection.close();
	    }
}
