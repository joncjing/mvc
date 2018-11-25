package com.demo.aspecj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author joncjing
 * @description
 * @date 2018/11/20-13/36
 **/
public class Timer {
    private static Logger logger = LoggerFactory.getLogger(Timer.class);

    public void printStartTime(){
        System.out.println("startTime is: "+ System.currentTimeMillis());
    }

    public void printEndTime(){
        System.out.println("endTime is: "+ System.currentTimeMillis());
    }
}
