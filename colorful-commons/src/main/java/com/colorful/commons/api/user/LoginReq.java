package com.colorful.commons.api.user;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @description:
 * @author chengdongyi
 * @date 2019/10/25 15:04
 */
@Data
public class LoginReq implements Serializable {

    private static final long serialVersionUID = 5319584720712687036L;

    /**
     * 用户名
     */
    @NotNull(message = "用户名不可为空")
    @Length(max = 10, message = "用户名长度不能超过10位")
    private String userName;

    /**
     * 密码
     */
    @NotNull(message = "密码不可为空")
    @Length(min = 6, message = "密码长度不能小于6位")
    private String password;

}
