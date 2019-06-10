package com.nieyue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class NacosConfigApplication implements ApplicationListener<ApplicationReadyEvent> {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigApplication.class, args);

    }


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

    }

}
