package demo.helper2;

import org.springframework.jms.core.JmsTemplate;


public class JmsTemplateFactoryV2 {

	private final javax.jms.ConnectionFactory factory;
	  private JmsTemplate topicJmsTemplate;
	  private JmsTemplate queueJmsTemplate;
	  public static JmsTemplateFactoryV2 getInstance()
	  {
	    return SingletonHolder.INSTANCE;
	  }
	  public JmsTemplateFactoryV2()
	  {
		  this.factory=ConnectionFactoryV2.getInstance();
	  }
	  
	  public static class SingletonHolder
	  {
	    static JmsTemplateFactoryV2 INSTANCE = new JmsTemplateFactoryV2();
	  }
}
