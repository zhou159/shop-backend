package com.zhou.shop.apiServer.common;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.zhou.shop.common.BaseConstant;
import com.zhou.shop.common.exception.ShopException;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

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
     * @param object 用户id
     * @param message 报错信息
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
        if (password.length() != 24) {
            throw new ShopException("该密码非密文，请维护！");
        }
        return SaSecureUtil.aesDecrypt(BaseConstant.AES_KEY, password);
    }

    public static String getIpAddress(HttpServletRequest request) {
        // 目前则是网关ip
        String ip = request.getHeader("X-Real-IP");
        if (ip != null && !"".equals(ip) && !BaseConstant.IP_UNKNOWN.equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (ip != null && !"".equals(ip) && !BaseConstant.IP_UNKNOWN.equalsIgnoreCase(ip)) {
            int index = ip.indexOf(',');
            if (index != -1) {
                // 只获取第一个值
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            // 取不到真实ip则返回空，不能返回内网地址。
            return BaseConstant.INNER_IP;
        }
    }

    public static String loadJson(String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL urlObject = new URL(url);
            URLConnection uc = urlObject.openConnection();
            uc.connect();
            InputStreamReader inn =
                    new InputStreamReader(
                            uc.getInputStream(), BaseConstant.CHARACTER_ENCODE_GB2313);

            BufferedReader in = new BufferedReader(inn);
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json.toString();
    }
}
