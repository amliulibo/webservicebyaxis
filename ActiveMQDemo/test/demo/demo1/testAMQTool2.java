package demo.demo1;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;

import org.junit.Before;
import org.junit.Test;

public class testAMQTool2 {

Map<String, String> bankMap=new HashMap<>();
	
	@Before
	
	public void InitTest() throws JMSException
	{
		bankMap.put("bank01", "tcp://localhost:61616");
		bankMap.put("bank02", "tcp://localhost:61616");
		bankMap.put("bank03", "tcp://localhost:61616");
		 
		
	}
	
	@Test
	public void start() throws JMSException
	{
		
		for (String bank : bankMap.keySet()) {
			AMQTool2 quque=new AMQTool2(bank,bankMap.get(bank));
			try {
				for (int i = 0; i < 3; i++) {
					quque.sendQueueMsg( bank+":"+String.valueOf(i));
					Thread.sleep(1000);
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
