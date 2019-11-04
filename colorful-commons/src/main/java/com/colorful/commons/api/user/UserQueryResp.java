package com.colorful.commons.api.user;
import lombok.Data;

import	java.io.Serializable;

@Data
public class UserQueryResp implements Serializable {

    private static final long serialVersionUID = 4242019160642312790L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 电子邮件
     */
    private String email;

}
