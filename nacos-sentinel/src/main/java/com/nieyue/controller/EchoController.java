package com.nieyue.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.nieyue.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EchoController {
    @Autowired
    EchoService echoService;
    @RequestMapping(value = "/echo", method = RequestMethod.GET)
    public String ec(
            @RequestParam("str")String str
            //@PathVariable("str") String str
    ) {
        return echoService.echo(str);
    }
}
