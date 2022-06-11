package com.zhou.shop.auth.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.zhou.shop.api.vo.user.login.UserLoginVO;
import com.zhou.shop.common.BaseConstant;
import com.zhou.shop.oss.redis.RedisUtil;
import com.zhou.shop.util.UuidUtil;
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
    @Autowired RedisUtil redisUtil;

    /**
     * 创建包含用户信息的token
     *
     * @return
     */
    public String getToken(UserLoginVO userLoginVO) {
        String token = "";
        token =
                JWT.create()
                        .withClaim(BaseConstant.TOKEN_USER_PWD, userLoginVO.getUserPassword())
                        .sign(Algorithm.HMAC256(userLoginVO.getUserPassword()));

        String uuid = UuidUtil.getUuid();
        redisUtil.setex(uuid, token, 1L, TimeUnit.DAYS);
        return uuid;
    }
}
