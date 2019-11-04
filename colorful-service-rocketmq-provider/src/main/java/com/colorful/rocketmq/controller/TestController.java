package com.colorful.rocketmq.controller;


import com.colorful.commons.domain.user.User;
import com.colorful.rocketmq.service.MqService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private MqService mqService;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String send()  {
        User user = new User();
        user.setId(1);
        user.setUserName("李四");
        user.setAge(18);
        user.setMobile("13012345678");
        user.setEmail("13012345678@qq.com");
        mqService.send(user);
        return "success";
    }

}
