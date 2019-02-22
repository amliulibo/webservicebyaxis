package demo;

public class receivetest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			new MQTool().TestMQConsumerQueue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
