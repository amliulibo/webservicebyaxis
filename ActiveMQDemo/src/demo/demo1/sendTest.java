package demo.demo1;

import java.util.Random;



public class sendTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 
		try {
			 
			sendOneQueue();
			
			 
			new AMQTool().QueueConsumer();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 
		
		
	}
	
	static void sendOneQueue() throws Exception
	{
		 
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 10; i++) 
				{
					try {
						 
						new AMQTool().QueueProducer();
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					 
				}
			}
		}).start();
		
		 
	}
	
	

}
