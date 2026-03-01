package com.swaglabs.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogsUtil {

    public static final String LOGS_PATH = "test-output/logs";

    private LogsUtil() {
        // Private constructor to prevent instantiation
        super();
        //super is used to call parent class constructor
    }

    public static Logger logger (){
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[3].getClassName());
    }

    public static void trace(String... message){
        logger().trace(String.join(" ",message));
    }
    public static void debug(String... message){
        logger().debug(String.join(" ",message));
    }
    public static void info(String... message) {
        logger().info(String.join(" ", message));
    }
    public static void warn(String... message) {
        logger().warn(String.join(" ", message));
    }
    public static void error(String... message) {
        logger().error(String.join(" ", message));
    }
    public static void fatal(String... message) {
        logger().fatal(String.join(" ", message));
    }
}
