package com.colorful.commons.api.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author chengdongyi
 * @date 2019/10/25 9:50
 */
@Data
public class UserQueryReq implements Serializable {

    private static final long serialVersionUID = 2261587112768454008L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

}
