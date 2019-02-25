package demo.demo2;

 
import org.springframework.jms.core.JmsTemplate;
/**
 * 模板厂
 * 
 * @author flm
 * 2017年10月13日
 */
public class JmsTemplateFactory
{
  private final javax.jms.ConnectionFactory factory;
  private JmsTemplate topicJmsTemplate;
  private JmsTemplate queueJmsTemplate;

  public static JmsTemplateFactory getInstance()
  {
    return SingletonHolder.INSTANCE;
  }

  private JmsTemplateFactory()
  {
    this.factory = ConnectionFactory.getInstance();
  }

  public synchronized JmsTemplate getTopicJmsTemplate() {
    if (this.topicJmsTemplate == null) {
      this.topicJmsTemplate = createTemplate(this.factory, true);
    }
    return this.topicJmsTemplate;
  }

  public synchronized JmsTemplate getQueueJmsTemplate() {
    if (this.queueJmsTemplate == null) {
      this.queueJmsTemplate = createTemplate(this.factory, false);
    }
    return this.queueJmsTemplate;
  }

  private JmsTemplate createTemplate(javax.jms.ConnectionFactory factory, boolean pubSubDomain) {
    JmsTemplate template = new JmsTemplate(factory);
    template.setPubSubDomain(pubSubDomain);
    return template;
  }

  public static class SingletonHolder
  {
    static JmsTemplateFactory INSTANCE = new JmsTemplateFactory();
  }
}
