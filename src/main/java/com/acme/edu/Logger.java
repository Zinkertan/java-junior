package com.acme.edu;

import com.acme.edu.message.type.arrays.IntContainerMessage;
import com.acme.edu.message.type.arrays.StringArrayMessage;
import com.acme.edu.message.type.*;

public class Logger {
    private static Controller logger = new Controller();

    private static boolean isSumming = false;

    public static void setSumming(boolean isSum){
        isSumming = isSum;
    }

    public static void log(int message) {
        logger.logMessage(new IntMessage(message,isSumming));
    }

    public static void log(int... message) {
        logger.logMessage(new IntContainerMessage(message,isSumming,1));
    }

    public static void log(int[]... message) {
        logger.logMessage(new IntContainerMessage(message,isSumming,2));
    }

    public static void log(int[][]... message) {
        logger.logMessage(new IntContainerMessage(message,isSumming,3));
    }

    public static void log(int[][][]... message) {
        logger.logMessage(new IntContainerMessage(message,isSumming,4));
    }

    public static void log(char message) {
        logger.logMessage(new CharMessage(message));
    }

    public static void log(byte message) {
        logger.logMessage(new ByteMessage(message,isSumming));
    }

    public static void log(String message) {
        logger.logMessage(new StringMessage(message,isSumming));
    }

    public static void log(String... message) {
        logger.logMessage(new StringArrayMessage(message,isSumming));
    }

    public static void log(Boolean message) {
        logger.logMessage(new BoolMessage(message));
    }

    public static void log(Object message) {
        logger.logMessage(new ObjectMessage(message));
    }

    public static void log(){
        logger.endLogging(true);
    }
}
