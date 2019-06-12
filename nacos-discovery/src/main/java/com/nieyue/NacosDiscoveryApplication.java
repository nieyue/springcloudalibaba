package com.nieyue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
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
    @RestController
    public class EchoController {
        @RequestMapping(value = "/echo/{str}",method = RequestMethod.GET)
        public String echo(@PathVariable("str") String str, HttpSession session) {
            System.out.println("sessionId="+session.getId());
            return "Hello Nacos Discovery =" + str;
        }
    }
}
