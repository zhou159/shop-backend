package com.zhou.shop.apiServer.common;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.zhou.shop.common.BaseConstant;
import com.zhou.shop.common.exception.ShopException;
import org.springframework.util.ObjectUtils;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0-2022/6/29 16:27-zhouxiong： 创建此类
 * @since 2022/6/29 16:27
 */
public class CommonMethodStatic {
    /**
     * 验证对象是否为空
     * @param object 对象
     * @param message 如非空则抛出的异常信息
     */
    public static void checkObjectNull(Object object, String message){
        if(!ObjectUtils.isEmpty(object)){
            throw new ShopException(message);
        }
    }

    /**
     * 验证对象是否非空
     * @param object 对象
     * @param message 如空则抛出的异常信息
     */
    public static void checkObjectNotNull(Object object, String message){
        if(ObjectUtils.isEmpty(object)){
            throw new ShopException(message);
        }
    }

    /**
     * 检验用户id
     * @param object
     * @param message
     */
    public static void checkUserId(Object object, String message){
        final Object loginId = StpUtil.getLoginId();
        checkObjectNotNull(loginId,"用户未登录!");
        if(!loginId.equals(object)){
            throw new ShopException(message);
        }
    }

    /**
     * 加密密码
     *
     * @param password 密码明文
     * @return 密码密文
     */
    public static String passwordEncrypt(String password) {
        return SaSecureUtil.aesEncrypt(BaseConstant.AES_KEY, password);
    }

    /**
     * 密码解密
     *
     * @param password 密码密文
     * @return 密码明文
     */
    public static String passwordDecrypt(String password) {
        return SaSecureUtil.aesDecrypt(BaseConstant.AES_KEY, password);
    }
}
