package demo.demo2;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.IOException;

import javax.jms.*;

import org.junit.Test;

import junit.framework.Assert;


public class JMSPublisherTest {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			//JMSListener.startJmsTopicListener("topic/send",new AMQ());// QM() 订阅 主题  topic/send
			JMSListener.startJmsQueueListener("demo2", new AMQ());
			
			for (int idx = 1; idx <= 3; idx++) {
				
				String mString=String.valueOf(idx * 1111);
				System.out.println("发送消息:"+mString);
				JMSPublisher.sendQueueMessage("demo2", mString);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
     * 生产者 发布消息
     * @throws 
     */
    @Test
    public void testSendMessage() throws InterruptedException {
        for (int idx = 1; idx <= 3; idx++) {
            
            /*
             * 生产者 发布 消息到 queue/queue_b 的队列中
             */
        	String mString=String.valueOf(idx * 1111);
        	System.out.println("发送消息:"+mString);
            JMSPublisher.sendQueueMessage("demo2",mString);
            Thread.sleep(1000);
            
            /*
             * 生产者 发布消息 到  topic/send 的Topic 主题中 
             */
            //JMSPublisher.sendTopicMessage("topic/send", String.valueOf(idx * 1111));
        }
       
        
        
    }

    
    /**
     * 消费者 订阅接受消息
     */
    @Test
    public void receiver() {
        /*
         * 消费者 订阅主题  topic/send 是否有消息发布，有侧打印出来  （通过 onMessage 监听）
         */
        /*JMSListener.startJmsTopicListener("topic/send", new MessageListener() {
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
        });*/
        
        /*
         * 消费者 订阅队列  queue/queue_b 是否有消息发布，有侧打印出来  （通过 onMessage 监听）
         */
       JMSListener.startJmsQueueListener("demo2" ,new MessageListener() {
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
        
         
		//System.in.read();
    }
}
