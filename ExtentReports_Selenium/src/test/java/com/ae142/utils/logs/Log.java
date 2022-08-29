package com.ae142.utils.logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
	
	/*
	//Creating LogManager obj
	static String LoggerName = "AE";
	private static Logger Log = 
			Logger.getLogger(LoggerName);
	*/
	
	//Was having problems initially because of the wrong logging imports
	private static final Logger Log = LogManager.getLogger(Log.class);
	
	
	public static void info(String message)
	{
		Log.info(message);
	}
	
	//Warn Level Logs
    public static void warn (String message) {
        Log.warn(message);
    }
    
    //Error Level Logs
    public static void error (String message) {
        Log.error(message);
    }
    //Fatal Level Logs
    public static void fatal (String message) {
        Log.fatal(message);
    }
    //Debug Level Logs
    public static void debug (String message) {
        Log.debug(message);
    }

}
