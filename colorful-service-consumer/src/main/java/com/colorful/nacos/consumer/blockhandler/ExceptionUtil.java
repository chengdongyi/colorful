package com.colorful.nacos.consumer.blockhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.colorful.commons.api.Resp;
import com.colorful.commons.api.user.LoginReq;
import com.colorful.commons.enums.ResultCode;


public class ExceptionUtil {

    /**
     * 限流函数
     */
    public static Resp loginBlock(LoginReq req, BlockException e) {

        return Resp.error(ResultCode.SERVICE_RESTRICTION);

    }

    /**
     * 异常函数
     */
    public static Resp loginFall(LoginReq req) {

        return Resp.error(ResultCode.SYSTEM_ERROR);

    }

}
