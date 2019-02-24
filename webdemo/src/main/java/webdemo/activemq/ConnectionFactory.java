package webdemo.activemq;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
/**
 * 连接工厂 配置
 * 
 * @author flm
 * 2017�?10�?13�?
 */
public class ConnectionFactory
{
  private static final String URL = "tcp://10.10.1.1:61616";
  private static final String USERNAME = "hkadmin";
  private static final String PASSWORD = "hk667";
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
    if ("tcp://10.10.1.1:61616" != null) {
      try {
        return new AMQConfigBean("tcp://10.10.1.1:61616", "hkadmin", "hk667", 20);
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