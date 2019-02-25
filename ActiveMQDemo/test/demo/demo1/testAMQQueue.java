package demo.demo1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;




@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testAMQQueue {
	Map<String, String> bankMap=new HashMap<>();
	@Before
	public void Init()
	{
		bankMap.put("bank工行", "tcp://localhost:61616");
		bankMap.put("bank建行", "tcp://localhost:61616");
		bankMap.put("bank中行", "tcp://localhost:61616");
	}
	/**
	 * 被动接受 
	 * @throws JMSException
	 */
	//@Test
	public void test01Consumer() throws JMSException
	{
		
		System.out.println("异步接收：");
		for (String bank : bankMap.keySet()) {
			new AMQQueueConsumer(bank, bankMap.get(bank)).Start();
		}
		
	}
	//@Test
	public void test01Consumer1() throws JMSException
	{
		
		System.out.println("异步自定义接收：");
		for (String bank : bankMap.keySet()) {
			new AMQQueueConsumer(bank, bankMap.get(bank),new MessageListener() {
				
				@Override
				public void onMessage(Message message) {
					 if(message instanceof TextMessage){
		                 TextMessage textMessage = (TextMessage)message;
		               
		                 
		                 try {
		                	//确认接收，并成功处理了消息
		                	 message.acknowledge();
		                     System.out.println("<<<<<<<<接收到消息:msg="+ textMessage.getText());
		                 } catch (JMSException e) {
		                     // TODO Auto-generated catch block
		                     e.printStackTrace();
		                 }
		             }
					
				}
			});
		}
		
	}
	
	
	@Test
	public void test02Producer()
	{
		for (String bank : bankMap.keySet()) {
			for (int i = 0; i < 3; i++) {
				try {
					new AMQQueueProducer(bank, bankMap.get(bank))
					.sendQueueMsg(bank+ "第"+ String.valueOf(i)+"次");
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	//@Test
	public void test010ProducerMT()
	{
		new Thread(new  Runnable() {
			public void run() {
				for (String bank : bankMap.keySet()) {
					for (int i = 0; i < 3; i++) {
						try {
							new AMQQueueProducer(bank, bankMap.get(bank))
							.sendQueueMsg(bank+ "第"+ String.valueOf(i)+"次");
							Thread.sleep(1000);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}).start();
		
		
	}
	
	/**
	 * 主动获取 
	 * @throws JMSException
	 */
	@Test
	public void test03Consumer()  
	{
		System.out.println("开始接收：");
		try {
			for (String bank : bankMap.keySet()) {
				AMQQueueConsumer consumer= new AMQQueueConsumer(bank, bankMap.get(bank)) ;
				List<String> list1= consumer.getTextMessage(10);
				for (String string : list1) {
					System.out.println("<<< 接收到消息："+string);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
		
		
	}
	
	

}
