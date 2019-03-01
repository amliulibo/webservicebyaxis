package demo4;

import java.io.IOException;

import helper.LogHelper;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LogHelper.debug("start");
		System.out.println("FFFFFFFFFF");
		
		LogHelper.debug("stop");
		try {
			int i1= System.in.read();
			System.err.println("i1="+ i1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
