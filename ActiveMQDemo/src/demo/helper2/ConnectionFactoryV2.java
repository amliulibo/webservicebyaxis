package demo.helper2;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.jms.connection.CachingConnectionFactory;




public class ConnectionFactoryV2 {

	private static final String BROKER_URL = "tcp://10.10.1.1:61616";
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
	
	private AMQConfigBean loadConfigure() {
	     AMQConfigBean configBean=new AMQConfigBean(BROKER_URL, USERNAME, PASSWORD, SESSIONCACHESIZE);
	     return configBean;
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
	
	private javax.jms.ConnectionFactory buildConnectionFactory(AMQConfigBean bean) {
	    javax.jms.ConnectionFactory targetFactory = new ActiveMQConnectionFactory(bean.getUserName(), bean.getPassword(), bean.getBrokerURL());

	    CachingConnectionFactory connectoryFacotry = new CachingConnectionFactory();
	    connectoryFacotry.setTargetConnectionFactory(targetFactory);
	    connectoryFacotry.setSessionCacheSize(bean.getSessionCacheSize());

	    return connectoryFacotry;
	  }

	private static class SingletonHolder
	  {
	    static ConnectionFactoryV2 INSTANCE = new ConnectionFactoryV2();
	  }
}
