package com.nieyue.fallback;

import com.nieyue.service.EchoService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 降级处理
 */
@Configuration
public class EchoServiceFallback implements EchoService {
    @Override
    public String echo(@PathVariable("str") String str) {
        return "echo fallback:"+str;
    }
}