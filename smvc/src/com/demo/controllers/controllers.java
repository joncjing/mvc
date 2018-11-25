package com.demo.controllers;

import com.demo.bean.User;
import com.demo.redis.dao.UserDao;
import com.demo.service.Performance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author joncjing
 * @description
 * @date 2018/11/20-15/13
 **/
@Controller
public class controllers {
    private static Logger logger = LoggerFactory.getLogger(controllers.class);

    @Autowired
    private Performance performance;

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@ModelAttribute("mvc") User user, ModelMap model){
        model.addAttribute("username",user.getUsername());
        model.addAttribute("address",user.getAddress());
        performance.perform();
        user.setAddress(user.getUsername());
        user.setUsername(user.getAddress());
        userDao.add(user);
        return "view";
    }

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView view(){

        return new ModelAndView("home","command",new User());
    }

    @RequestMapping(value = "/home1",method = RequestMethod.GET)
    public ModelAndView home(){
        return new ModelAndView("redis","command",new User());
    }

    @RequestMapping(value = "/redis",method = RequestMethod.POST)
    public void testReids(String host, String username, String password, String db, Model model){
        model.addAttribute("host",host);
        model.addAttribute("username",username);
        model.addAttribute("password",password);
        model.addAttribute("db",db);

        User U=new User();
        U.setUsername(username);
        U.setAddress(host);
        userDao.add(U);

        System.out.println(username);
    }
}
