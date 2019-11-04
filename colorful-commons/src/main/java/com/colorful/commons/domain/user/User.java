package com.colorful.commons.domain.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: t_user : 用户信息表
 * @author chengdongyi
 * @date 2019/10/25 9:48
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1524809017574105879L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

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
