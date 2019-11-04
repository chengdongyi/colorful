package com.colorful.rocketmq.service;

import com.alibaba.fastjson.JSON;
import com.colorful.commons.domain.user.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MqService {

    @Resource
    @Qualifier("output")
    private MessageChannel output;

    public void send(User user) {
        output.send(MessageBuilder.withPayload(JSON.toJSONString(user)).build());
    }

}
