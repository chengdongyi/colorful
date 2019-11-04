package com.colorful.rocketmq.service;

import com.colorful.commons.domain.user.User;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author chengdongyi
 * @date 2019/10/30 17:16
 */
@Service
public class MqService {

    @StreamListener("input")
    public void receiveInput(User user) {
        System.out.println("Receive input: " + user);
    }

}
