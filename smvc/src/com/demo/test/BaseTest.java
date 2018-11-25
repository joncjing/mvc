package com.demo.test;

import com.demo.bean.User;
import com.demo.redis.dao.UserDao;
import com.demo.service.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author joncjing
 * @description
 * @date 2018/11/21-14/27
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:db.xml")
public class BaseTest {

    @Autowired
    private Performance performance;

    @Autowired
    private UserDao userDao;

    @Test
    public void testDemo(){
        performance.perform();
    }

    @Test
    public void testRedis(){
        User user = new User();
        user.setUsername("name");
        user.setAddress("cd");
        userDao.add(user);
    }
}
