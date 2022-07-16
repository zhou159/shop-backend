package com.zhou.shop.apply.annotations;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouxiong
 * @version v0.1
 * @since 2022/7/15 11:47
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
@Inherited
public @interface RequestLimit {
    /**
     * 次数（默认为1）
     */
    int count() default 1;

    /**
     * 时间（默认1000）
     */
    long time() default 1000;

    /**
     * 时间单位（默认毫秒）
     */
    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;
}
