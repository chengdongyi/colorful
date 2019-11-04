package com.colorful.nacos.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.colorful.commons.api.Resp;
import com.colorful.commons.api.user.LoginReq;
import com.colorful.nacos.consumer.blockhandler.ExceptionUtil;
import com.colorful.nacos.consumer.feign.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private UserService userService;

    @PostMapping("/test")
    @SentinelResource(value = "resource", blockHandler = "loginBlock", blockHandlerClass = {ExceptionUtil.class})
    public Resp login(@RequestBody LoginReq req) {

        return userService.login(req);

    }

    @PostMapping("/test1")
    @SentinelResource(value = "resource", fallback = "loginFall", fallbackClass = {ExceptionUtil.class})
    public Resp login1(@RequestBody LoginReq req) {

        int a = 10 / 0;
        return userService.login(req);

    }

}
