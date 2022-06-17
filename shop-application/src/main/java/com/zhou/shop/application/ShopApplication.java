package com.zhou.shop.application;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.hutool.core.util.RandomUtil;
import com.zhou.shop.common.BaseConstant;
import com.zhou.shop.common.enums.SourceEnum;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;

@MapperScan("com.zhou.shop.apiServer.mapper")
@ComponentScan(basePackages = {"com.zhou.shop.**"})
@SpringBootApplication
@EnableConfigurationProperties
public class ShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

    @Test
    public void security() throws Exception {
        final HashMap<String, String> stringStringHashMap = SaSecureUtil.rsaGenerateKeyPair();
        final String aPrivate = stringStringHashMap.get("private");
        final String aPublic = stringStringHashMap.get("public");
        String text = "Sa-Token一个轻量级java权限认证框架" + BaseConstant.AES_KEY;

        final String s = RandomUtil.randomString(SourceEnum.numLetter.getSources(), 32);
        System.out.println(SaSecureUtil.aesEncrypt(s, text));
        System.out.println();
        //        String key = "123456";

        //
        //        System.out.println(SaSecureUtil.aesEncrypt(BaseConstant.AES_KEY, text));
        //
        //        System.out.println(
        //                SaSecureUtil.aesDecrypt(
        //                        BaseConstant.AES_KEY,
        // SaSecureUtil.aesEncrypt(BaseConstant.AES_KEY, text)));
    }
}
