package com.colorful.nacos.consumer.feign.fallback;

import com.colorful.commons.api.Resp;
import com.colorful.commons.api.user.LoginReq;
import com.colorful.commons.enums.ResultCode;
import com.colorful.nacos.consumer.feign.UserService;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author chengdongyi
 * @date 2019/10/28 12:17
 */
@Component
public class UserServiceFallback implements UserService {

    @Override
    public Resp login(LoginReq req) {
        return Resp.error(ResultCode.SERVICE_ERROR);
    }

}
