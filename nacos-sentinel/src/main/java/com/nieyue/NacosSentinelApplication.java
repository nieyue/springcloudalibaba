package com.nieyue;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.nieyue.blockhandler.BlockHandlerUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosSentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosSentinelApplication.class, args);
    }
    @Bean
    @SentinelRestTemplate(blockHandler = "handleException", blockHandlerClass = BlockHandlerUtil.class)
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
