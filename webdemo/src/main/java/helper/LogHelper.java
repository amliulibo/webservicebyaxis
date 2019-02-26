package helper;

import org.apache.log4j.Logger;

public class LogHelper {
	
	private static final Logger logger=Logger.getLogger(LogHelper.class);
	
	public static void debug(String msg)
	{
		logger.debug(msg);
	}
	

}
