package demo;

public class sendTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			new MQTool().QueueProducer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
