package com.colorful.nacos.consumer.feign;

import com.colorful.commons.api.Resp;
import com.colorful.commons.api.user.LoginReq;
import com.colorful.nacos.consumer.feign.fallback.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "colorful-service-provider", fallback = UserServiceFallback.class)
public interface UserService {

    @PostMapping("/user/login")
    Resp login(@RequestBody LoginReq req);

}
