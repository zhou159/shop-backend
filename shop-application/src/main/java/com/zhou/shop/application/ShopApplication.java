package com.zhou.shop.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.zhou.shop.apiServer.mapper")
@ComponentScan(basePackages = {"com.zhou.shop.**"})
@SpringBootApplication
@EnableConfigurationProperties
public class ShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }
}
