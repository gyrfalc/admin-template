package com.csc.admin.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;


public class AdminUtils {
    private static Logger log = Logger.getLogger(AdminUtils.class);
	
	public static boolean isEmpty(String s) {
		return (s== null) || (s.length() == 0);
	}
	public static boolean isNotEmpty(String s) {
		return !isEmpty(s);
	}
	public static boolean isEmpty(Integer i) {
		return i == null;
	}
	public static boolean isNotEmpty(Integer i) {
		return i != null;
	}

    /**
    * Read a properties file from the classpath and return a Properties object
    * @param filename
    * @return
    * @throws IOException
    */
    static public Properties readProperties(String filename) throws IOException{
    	log.debug("read properties for file: " + filename);
        Properties props = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        log.debug("opening stream...");
        InputStream stream = loader.getResourceAsStream(filename);
        log.debug("loading properties...");
        props.load(stream);
        log.debug("returning properties to caller...");
        return props;
    }
}
