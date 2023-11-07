package com.veerendra.biradar.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppLog {

    Logger logger;

    protected AppLog(Class<?> clazz) {
        logger = LogManager.getLogger(clazz);
    }

    public void info(String msg) {
        logger.info(Thread.currentThread().getStackTrace()[2].getLineNumber() + ":: message=" + msg);
    }

    public void error(String msg) {
        logger.error(Thread.currentThread().getStackTrace()[2].getLineNumber() + ":: message=" + msg);
    }

    public void error(String msg, Throwable t) {
        logger.error(Thread.currentThread().getStackTrace()[2].getLineNumber() + ":: message=" + msg, t);

    }

}
