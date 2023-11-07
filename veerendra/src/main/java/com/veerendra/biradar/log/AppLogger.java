package com.veerendra.biradar.log;

public class AppLogger {

    public static AppLog getAppLog(Class<?> clazz) {
        return new AppLog(clazz);
    }

}
