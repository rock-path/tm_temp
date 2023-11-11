package com.psh.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StaticConfig {


    private static Integer timeOut;


    @Value("${session.timeOut}")
    public void setVar3(String timeOut) {
        timeOut = timeOut;
    }

    public static Integer getTimeOut() {
        return timeOut;
    }


}
