package com.colorful.commons.utils;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @description: JSR303参数校验
 * @author chengdongyi
 * @date 2019/8/9 17:50
 */
@Component
public class Validate {

//    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Resource
    private Validator validatorInstance;

    private static Validator validator;

    @PostConstruct
    public void init() {
        Validate.validator = validatorInstance;
    }

    /**
     * 功能描述: 服务端参数有效性验证
     * @author chengdongyi
     * @date 2019/9/17 14:42
     * @param object 验证的实体对象
     * @param groups 验证组
     * @return java.lang.String 验证成功: 返回 null; 验证失败: 返回错误信息;
     */
    public static String validator(Object object, Class<?>... groups) {

        try {
            validateWithException(validator, object, groups);
        } catch (ConstraintViolationException ex) {
            List<String> list = extractMessage(ex);
            list.add(0, "参数校验失败: ");
            // 封装错误消息为字符串
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                String msg = list.get(i);
                if (i != 0) {
                    sb.append(String.format("%s.%s", i, msg)).append(i == list.size() - 1 ? ";" : "; ");
                } else {
                    sb.append(msg);
                }
            }
            return sb.toString();
        }
        return null;
    }

    /**
     * 调用 JSR303 的 validate 方法, 验证失败时抛出 ConstraintViolationException.
     */
    private static void validateWithException(Validator validator, Object object, Class<?>... groups) throws ConstraintViolationException {
        Set constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }

    /**
     * 转换 ConstraintViolationException 中的 Set<ConstraintViolations> 中为 List<message>.
     */
    private static List<String> extractMessage(ConstraintViolationException e) {
        return extractMessage(e.getConstraintViolations());
    }

    /**
     * 转换 Set<ConstraintViolation> 为 List<message>
     */
    private static List<String> extractMessage(Set<? extends ConstraintViolation> constraintViolations) {
        List<String> errorMessages = new ArrayList<>();
        for (ConstraintViolation violation : constraintViolations) {
            errorMessages.add(violation.getMessage());
        }
        return errorMessages;
    }

}
