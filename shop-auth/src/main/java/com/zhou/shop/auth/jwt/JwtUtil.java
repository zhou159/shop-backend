package com.zhou.shop.auth.jwt;

import cn.hutool.core.lang.Snowflake;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.zhou.shop.api.dto.UserLoginDTO;
import com.zhou.shop.common.BaseConstant;
import com.zhou.shop.oss.redis.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author 周雄
 * @description:
 * @version: v1.0
 * @since 2022/6/10 17:33
 */
@Component
public class JwtUtil {
    private final Logger logger = LoggerFactory.getLogger(JwtUtil.class);
    @Autowired RedisUtil redisUtil;

    /**
     * 创建包含用户信息的token
     *
     * @return
     */
    public String getToken(UserLoginDTO userLoginDTO, String password) {
        String tokenValue =
                JWT.create()
                        .withClaim(BaseConstant.TOKEN_USER_ID, userLoginDTO.getUserId())
                        .sign(Algorithm.HMAC256(password));

        final Snowflake snowflake = new Snowflake();
        final String tokenKey = String.valueOf(snowflake.nextId());
        logger.info("雪花算法生成token键值:{}", tokenKey);
        redisUtil.setex(tokenKey, tokenValue, 1L, TimeUnit.DAYS);
        return tokenKey;
    }
}
