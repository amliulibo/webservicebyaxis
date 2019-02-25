package demo.demo2;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
/**
 * 连接工厂 配置
 * 
 * @author  
 *  
 */
public class ConnectionFactory
{
  private static final String URL = "tcp://localhost:61616";
  private static final String USERNAME = "admin";
  private static final String PASSWORD = "admin";
  private static final int SESSIONCACHESIZE = 20;
  private javax.jms.ConnectionFactory factory;

  public static synchronized javax.jms.ConnectionFactory getInstance()
  {
    if (SingletonHolder.INSTANCE.factory == null) {
      SingletonHolder.INSTANCE.build();
    }
    return SingletonHolder.INSTANCE.factory;
  }

  private void build()
  {
    AMQConfigBean bean = loadConfigure();
    this.factory = buildConnectionFactory(bean);
  }

  private javax.jms.ConnectionFactory buildConnectionFactory(AMQConfigBean bean) {
    javax.jms.ConnectionFactory targetFactory = new ActiveMQConnectionFactory(bean.getUserName(), bean.getPassword(), bean.getBrokerURL());

    CachingConnectionFactory connectoryFacotry = new CachingConnectionFactory();
    connectoryFacotry.setTargetConnectionFactory(targetFactory);
    connectoryFacotry.setSessionCacheSize(bean.getSessionCacheSize());

    return connectoryFacotry;
  }

  private AMQConfigBean loadConfigure() {
    if (URL != null) {
      try {
        return new AMQConfigBean(URL, USERNAME, PASSWORD, 20);
      } catch (Exception e) {
        throw new IllegalStateException("load amq config error!");
      }
    }
    throw new IllegalStateException("load amq config error!");
  }

  private static class AMQConfigBean
  {
    private String brokerURL;
    private String userName;
    private String password;
    private int sessionCacheSize;

    public AMQConfigBean() {
    }

    public AMQConfigBean(String brokerURL, String userName, String password, int sessionCacheSize) {
      this.brokerURL = brokerURL;
      this.userName = userName;
      this.password = password;
      this.sessionCacheSize = sessionCacheSize;
    }

    public String getBrokerURL() {
      return this.brokerURL;
    }

    public void setBrokerURL(String brokerURL) {
      this.brokerURL = brokerURL;
    }

    public String getUserName() {
      return this.userName;
    }

    public void setUserName(String userName) {
      this.userName = userName;
    }

    public String getPassword() {
      return this.password;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    public int getSessionCacheSize() {
      return this.sessionCacheSize;
    }

    public void setSessionCacheSize(int sessionCacheSize) {
      this.sessionCacheSize = sessionCacheSize;
    }
  }

  private static class SingletonHolder
  {
    static ConnectionFactory INSTANCE = new ConnectionFactory();
  }
}