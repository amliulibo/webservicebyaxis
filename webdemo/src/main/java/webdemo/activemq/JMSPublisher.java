package webdemo.activemq;

 
 import javax.jms.*;

import org.springframework.jms.core.MessageCreator;

/**
 * 创建 jms生产者
 * 
 * @author flm
 * 2017年10月13日
 */
public class JMSPublisher
{

 /**
	 　　* 发送消息
	 　　* Topic 生产者 
	 　　* @param dest  目的地
	 　　* @param msg   消息内容
	 　　*/
public static void sendTopicMessage(String dest, String msg)
  {
	
	
    JmsTemplateFactory.getInstance().getTopicJmsTemplate().send(dest, new MessageCreator() {
		
		public Message createMessage(Session session) throws JMSException {
			// TODO Auto-generated method stub
			return session.createTextMessage("msg");
		}
	});
  }


 /**
     　　* 发送消息
	 　　* Queue 生产者 
	 　　* 
	 　　* @param dest  目的地
	 　　* @param msg   消息内容
	 　　*/
public static void sendQueueMessage(String dest, String msg)
  {
    JmsTemplateFactory.getInstance().getQueueJmsTemplate().send(dest, new MessageCreator()
    {
      public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage("msg");
      }
    });
  }
}