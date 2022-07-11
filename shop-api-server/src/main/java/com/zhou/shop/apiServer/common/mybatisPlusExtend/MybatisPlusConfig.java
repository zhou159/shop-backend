package com.zhou.shop.apiServer.common.mybatisPlusExtend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhouxiong
 * @version v0.1
 * @since 2022/7/6 11:34
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * 扩展mapper方法
     */
    @Bean
    public ExpandSqlInjector expandSqlInjector() {
        return new ExpandSqlInjector();
    }

}
