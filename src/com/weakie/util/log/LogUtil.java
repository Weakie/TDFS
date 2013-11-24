package com.weakie.util.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtil {

	public static void error(String msg) {
		Logger logger = getLogger();
		logger.error(msg);
	}

	public static void warn(String msg) {
		Logger logger = getLogger();
		logger.warn(msg);
	}

	public static void info(String msg) {
		Logger logger = getLogger();
		logger.info(msg);
	}

	public static void debug(String msg) {
		Logger logger = getLogger();
		logger.debug(msg);
	}
	
	public static void error(Throwable t) {
		Logger logger = getLogger(t);
		logger.error(t);
	}

	public static void warn(Throwable t) {
		Logger logger = getLogger(t);
		logger.warn(t);
	}

	public static void info(Throwable t) {
		Logger logger = getLogger(t);
		logger.info(t);
	}

	public static void debug(Throwable t) {
		Logger logger = getLogger(t);
		logger.debug(t);
	}
	
	private static Logger getLogger(){
		Exception e = new Exception();
		StackTraceElement element = e.getStackTrace()[1];
		Logger logger = LogManager.getLogger(element.getClassName());
		return logger;
	}
	
	private static Logger getLogger(Throwable t){
		StackTraceElement element = t.getStackTrace()[0];
		Logger logger = LogManager.getLogger(element.getClassName());
		return logger;
	}
}
