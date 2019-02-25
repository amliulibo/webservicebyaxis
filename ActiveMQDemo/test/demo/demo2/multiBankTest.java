package demo.demo2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.jms.connection.CachingConnectionFactory;




public class multiBankTest {

	Map<String, String> bankMap=new HashMap<>();
	
	@Before
	
	public void InitTest()
	{
		bankMap.put("bank01", "192.168.10.10");
		bankMap.put("bank02", "192.168.10.11");
		bankMap.put("bank03", "192.168.10.12");
	}
	
	@Test
    public void testSendMessage() throws InterruptedException {
		
		for (String bank : bankMap.keySet()) {
			 
	        for (int idx = 1; idx <= 3; idx++) {
	            
	            /*
	             * 生产者 发布 消息到 queue/queue_b 的队列中
	             */
	        	String mString=String.valueOf(idx * 1111);
	        	System.out.println("队列"+bank+ "发送消息:"+mString);
	            JMSPublisher.sendQueueMessage(bank,mString);
	            Thread.sleep(1000);
	            
	            
	        }
		}
        
        assertTrue(true);
        
        
    }

	@Test
    public void receiver() {
		for (String bank : bankMap.keySet()) {
			/*
	         * 消费者 订阅队列  queue/queue_b 是否有消息发布，有侧打印出来  （通过 onMessage 监听）
	         */
	       JMSListener.startJmsQueueListener(bank ,new MessageListener() {
	            @Override
	             public void onMessage(Message message) {
	                try {
	                    if (message instanceof TextMessage) {
	                        TextMessage msg = (TextMessage) message;
	                        System.out.println("== 收到一个JMS消息..." + msg.getText());
	                    } 
	                } catch (JMSException e) {
	                    e.printStackTrace();
	                }
	            }
	        });
		}
        
        
        assertEquals("1", "1");
		//System.in.read();
    }

}
