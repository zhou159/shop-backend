package com.zhou.shop.apply.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/11 16:25
 */
@Deprecated
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotLogin {
    boolean required() default true;
}
