package com.colorful.commons.api;

import com.colorful.commons.enums.ResultCode;
import lombok.Data;

/**
 * @description:
 * @author chengdongyi
 * @date 2019/10/22 15:25
 */
@Data
public class Resp<T> {

    private String code;
    private String msg;
    private T data;

    public Resp() {

    }

    public Resp(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Resp(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Resp error(ResultCode result) {
        return new Resp(result.code(), result.message());
    }

    public static Resp error(ResultCode result, String message) {
        if (result.hashCode() == ResultCode.SYSTEM_ERROR.hashCode()) {
            return new Resp(result.code(), result.message() + message);
        }
        return new Resp(result.code(), message);
    }

    public static Resp success() {
        return new Resp(ResultCode.SUCCESS.code(), ResultCode.SUCCESS.message(), null);
    }

    public static Resp success(Object data) {
        return new Resp(ResultCode.SUCCESS.code(), ResultCode.SUCCESS.message(), data);
    }

}
