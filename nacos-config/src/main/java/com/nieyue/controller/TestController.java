package com.nieyue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RefreshScope
public class TestController {
    @Value("${user.name}")
    String userName;
    @Value("${user.age}")
    String userAge;
    @Value("${current.env}")
    String currentEnv;
    @Autowired
   // ConfigurableApplicationContext applicationContext;
    @RequestMapping("/nacosconfig")
    String test(){
       // String userName = applicationContext.getEnvironment().getProperty("user.name");
       // String userAge = applicationContext.getEnvironment().getProperty("user.age");
       // 获取当前部署的环境
       // String currentEnv = applicationContext.getEnvironment().getProperty("current.env");
       return "in "+currentEnv+" enviroment; "+"user name :" + userName + "; age: " + userAge;
    }
}
