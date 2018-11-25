package com.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author joncjing
 * @description
 * @date 2018/11/19-16/31
 **/
@Configuration
@ComponentScan
public class Config {
    private static Logger logger = LoggerFactory.getLogger(Config.class);
}
