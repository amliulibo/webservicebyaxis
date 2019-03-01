package demo2;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

import org.junit.Test;

import demo2.Worker;

 


public class WorkerTest {

	//@Test
	 public void test01()
	 {
		try {
			Worker.main(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 }
	@Test
	public void test11()
	 {
		NewTask.main(null);
	 }
	 
}
