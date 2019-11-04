package com.colorful.nacos.provider.controller;

import com.colorful.commons.api.Resp;
import com.colorful.commons.api.user.LoginReq;
import com.colorful.commons.domain.user.User;
import com.colorful.commons.enums.ResultCode;
import com.colorful.commons.utils.Validate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {

    @GetMapping("/getUserInfo/{id}")
    public Resp getUserInfo(@PathVariable Integer id) {

        User user = new User();
        user.setId(1);
        user.setUserName("zhangsan");
        user.setPassword("123456");
        user.setAge(18);
        user.setMobile("13012345678");
        user.setEmail("13012345678@163.com");
        return Resp.success(user);
    }

    @PostMapping("/login")
    public Resp login(@RequestBody LoginReq req) {

        String message = Validate.validator(req);
        if (StringUtils.isNotBlank(message)) {
            return Resp.error(ResultCode.PARAME_ERROR, message);
        }

        User user = new User();
        user.setId(1);
        user.setUserName("zhangsan");
        user.setPassword("123456");
        user.setAge(18);
        user.setMobile("13012345678");
        user.setEmail("13012345678@163.com");
        return Resp.success(user);
    }

}
