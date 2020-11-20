package com.nieyue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosDiscoveryApplication.class, args);
    }
    @Autowired
    StringRedisTemplate srt;
    @RestController
    public class EchoController {
        @RequestMapping(value = "/echo/{str}",method = RequestMethod.GET)
        public String echo(@PathVariable("str") String str, HttpSession session) {
            System.out.println("sessionId="+session.getId());
            BoundValueOperations<String, String> srttest = srt.boundValueOps("test");
            String sid=session.getId();
            if(StringUtils.isEmpty(srttest.get())){
                srttest.set("sessionId="+sid);
            }else{
                sid=srttest.get();
            }

            return "Hello Nacos Discovery sessionId=" + sid;
        }
    }
}
