package com.czht.smartpark.tbweb.context.aop.annotation;

import java.lang.annotation.*;

/**
 * 权限，可传递权限名称，优先级第一，如果设置了权限名称，则只有这一个权限，否则根据登陆用户的权限判断是否有权
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Permission {
    String value() default "";
}