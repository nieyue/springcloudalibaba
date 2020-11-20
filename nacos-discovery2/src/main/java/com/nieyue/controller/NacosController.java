package com.nieyue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

@RestController
public class NacosController{

        @Autowired
        private LoadBalancerClient loadBalancerClient;
        @Autowired
        private RestTemplate rt;

        @Value("${spring.application.name}")
        private String appName;

        @GetMapping("/echo/app-name")
        public String echoAppName(){
            //使用 LoadBalanceClient 和 RestTemolate 结合的方式来访问
            ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");
            String url = String.format("http://%s:%s/echo/%s",serviceInstance.getHost(),serviceInstance.getPort(),appName);
            System.out.println("request url:"+url);
            return rt.getForObject(url,String.class);
        }
        @Autowired
    StringRedisTemplate srt;
        @GetMapping("/echo/discovery2")
        public String discovery2(HttpSession session){
            BoundValueOperations<String, String> srttest = srt.boundValueOps("test");
            String sid=session.getId();
            if(StringUtils.isEmpty(srttest.get())){
                srttest.set("sessionId="+sid);
            }else{
                sid=srttest.get();
            }

            return "Hello Nacos Discovery2 sessionId=" + sid;
        }

    }
