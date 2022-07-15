package com.zhou.shop.apply.annotations;

import java.lang.annotation.*;

/**
 * 自定义日志
 *
 * @author zhouxiong
 * @description:
 * @version: v1.0-2022/6/23 8:57-zhouxiong： 创建此类
 * @since 2022/6/23 8:57
 */
@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLog {}
