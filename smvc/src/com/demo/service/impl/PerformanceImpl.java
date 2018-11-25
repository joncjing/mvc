package com.demo.service.impl;

import com.demo.service.Performance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author joncjing
 * @description
 * @date 2018/11/20-13/42
 **/
@Component
public class PerformanceImpl implements Performance {
    private static Logger logger = LoggerFactory.getLogger(PerformanceImpl.class);

    @Override
    public void perform() {
        System.out.println("magic is playing");
    }
}
