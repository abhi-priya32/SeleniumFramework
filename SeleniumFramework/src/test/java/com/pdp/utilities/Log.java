package com.pdp.utilities;

import org.apache.log4j.Logger;

public class Log {
	
	
	static Logger Log= Logger.getLogger(Log.class.getName());
	
	public static void main (String [] args) {
		
		
	}
	
	public static void startTestCase(String sTestCaseName) {
		Log.info("**********************************************************************");
		Log.info("***********************************************************************");
		Log.info("$$$$$$$$$$   "+ sTestCaseName+"      $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		Log.info("**********************************************************************");
		Log.info("***********************************************************************");		
	}
	
	//This is to print log at the ending of the tes case
	public static void endTestCase(String sTestCaseName) {
		
		Log.info("$$$$$$$$$$   "+ sTestCaseName+"      $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	}
	
	//need to create these methods so that they can be called
	
	public static void info(String message) {
		Log.info(message);
	}
	
	public static void warn(String message) {
		Log.info(message);
	}
	
	public static void error(String message) {
		Log.info(message);
	}
	
	public static void fatal(String message) {
		Log.info(message);
	}
	
	public static void debug(String message) {
		Log.info(message);
	}
}
