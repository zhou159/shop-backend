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
     *
     * @param object 对象
     * @param message 如非空则抛出的异常信息
     */
    public static void checkObjectNull(Object object, String message) {
        if (!ObjectUtils.isEmpty(object)) {
            throw new ShopException(message);
        }
    }

    /**
     * 验证对象是否非空
     *
     * @param object 对象
     * @param message 如空则抛出的异常信息
     */
    public static void checkObjectNotNull(Object object, String message) {
        if (ObjectUtils.isEmpty(object)) {
            throw new ShopException(message);
        }
    }

    /**
     * 检验用户id
     *
     * @param object 用户id
     * @param message 报错信息
     */
    public static void checkUserId(Object object, String message) {
        final Object loginId = StpUtil.getLoginId();
        checkObjectNotNull(loginId, "用户未登录!");
        if (!loginId.equals(object)) {
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

    /**
     * 获取请求的ip地址
     *
     * @param request 请求
     * @return IP地址
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || BaseConstant.IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }
        if (ip == null || ip.length() == 0 || BaseConstant.IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || BaseConstant.IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || BaseConstant.IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (ip.equals(BaseConstant.LOCALHOST_IP) || ip.equals(BaseConstant.LOCALHOST_IPV6)) {
                return BaseConstant.INNER_IP;
            }
        }

        // 多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ip.length() > 15) {
            if (ip.indexOf(BaseConstant.CHAR_COMMA) > 0) {
                return ip.substring(0, ip.indexOf(","));
            }
        }

        return ip;
    }

    /**
     * 远程调用获取结果的json值
     *
     * @param url url
     * @return json字符串
     */
    public static String loadJson(String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL urlObject = new URL(url);
            URLConnection uc = urlObject.openConnection();
            uc.connect();
            InputStreamReader inn =
                    new InputStreamReader(uc.getInputStream(), BaseConstant.CHARACTER_ENCODE_GBK);

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
