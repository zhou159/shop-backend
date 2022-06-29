package com.zhou.shop.apiServer.common;

import cn.hutool.core.util.StrUtil;
import com.zhou.shop.apiServer.service.impl.user.UserLoginServiceImpl;
import com.zhou.shop.common.exception.CheckCodeErrorException;
import com.zhou.shop.oss.redis.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0-2022/6/29 15:59-zhouxiong： 创建此类
 * @since 2022/6/29 15:59
 */
@Component
public class CommonMethods {
    private final RedisUtil redisUtil;
    private final Logger log = LoggerFactory.getLogger(UserLoginServiceImpl.class);

    public CommonMethods(RedisUtil redisUtil) {this.redisUtil = redisUtil;}

    /**
     * 验证码校验（为什么不写成静态方法呢？因为redis工具类不能写成静态类）
     * @param key redis键
     * @param value 输入的验证码
     */
    public void checkVerifyCode(String key, String value){
        String redisCode = (String) redisUtil.get(key);
        // 获取前端输入的验证码并将小写字母转成大写字母
        value = value.toUpperCase();

        log.info("redis验证码：{}，用户输入验证码：{}", redisCode, value);
        if (!StrUtil.equals(redisCode, value)) {
            throw new CheckCodeErrorException("验证码输入错误！");
        }
    }
}
