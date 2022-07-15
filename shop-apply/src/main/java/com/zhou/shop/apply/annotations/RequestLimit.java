package com.zhou.shop.apply.annotations;

import java.lang.annotation.*;

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
    
    int count() default 1;
    long time() default 1000;
}
