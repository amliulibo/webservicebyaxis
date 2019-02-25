package demo.demo1;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;

public class AMQTool {
	
	private static final String BROKER_URL="tcp://localhost:61616";
	
	public void QueueProducer() throws Exception{
        //1、创建工厂连接对象，需要制定ip和端口号
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        //2、使用连接工厂创建一个连接对象
        Connection connection = connectionFactory.createConnection();
        //3、开启连接
        connection.start();
        //4、使用连接对象创建会话（session）对象
        //此方法第一个参数表示会话是否在事务中执行，第二个参数设定会话的应答模式
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5、使用会话对象创建目标对象，包含queue或topic（一对一或一对多）
        Queue queue = session.createQueue("test-queue");
        //6、创建消息生产者对象
        MessageProducer producer = session.createProducer(queue);
        //7、使用会话对象创建一个消息对象
        TextMessage textMessage = session.createTextMessage("hello!test-queue2");
        //8、发送消息
        producer.send(textMessage);
        System.out.println(">>>>>>>>>>我发送的消息是:"+textMessage.getText());
        //9、关闭资源
        producer.close();
        session.close();
        connection.close();
    }
	public void QueueConsumer() throws Exception{
        //1、创建工厂连接对象，需要制定ip和端口号
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        //2、使用连接工厂创建一个连接对象
        Connection connection = connectionFactory.createConnection();
        //3、开启连接
        connection.start();
        //4、使用连接对象创建会话（session）对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5、使用会话对象创建目标对象，包含queue和topic（一对一和一对多）
        Queue queue = session.createQueue("test-queue");
        //6、创建消费者对象
        MessageConsumer consumer = session.createConsumer(queue);
        //7、向consumer对象中设置一个messageListener对象，用来接收消息
        consumer.setMessageListener(new MessageListener() {

            @Override
            public void onMessage(Message message) {
                // TODO Auto-generated method stub
                if(message instanceof TextMessage){
                    TextMessage textMessage = (TextMessage)message;
                    try {
                        System.out.println(">>>>>>>>>>我接收到的消息是:"+textMessage.getText());
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
