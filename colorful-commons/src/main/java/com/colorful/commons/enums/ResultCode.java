package com.colorful.commons.enums;

import java.util.HashMap;

/**
 * @description: 返回码
 * @author chengdongyi
 * @date 2019/10/25 10:18
 */
public enum ResultCode {

    SUCCESS("0", "成功"),
    FAIL("-1", "失败"),
    PARAME_ERROR("200001", "参数错误"),
    TOKEN_ERROR("201001", "参数错误"),
    INTERFACE_ERROR("800001", "依赖接口异常, 请稍后再试!"),
    SERVICE_ERROR("800002", "依赖服务异常, 请稍后再试!"),
    SERVICE_RESTRICTION("800003", "服务限流, 请稍后再试!"),
    SYSTEM_ERROR("999999", "系统异常: ");

    private String code;

    private String message;

    private static HashMap<String, ResultCode> maps = new HashMap<>();

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    static {
        for (ResultCode result : ResultCode.values()) {
            maps.put(result.code, result);
        }
    }

    public static ResultCode parse(String code) {
        if (maps.containsKey(code)) {
            return maps.get(code);
        }
        return null;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

}
