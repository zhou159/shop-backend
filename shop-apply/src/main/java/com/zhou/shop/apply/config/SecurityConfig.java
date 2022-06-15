package com.zhou.shop.apply.config;

import org.springframework.stereotype.Component;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/15 21:04
 */
@Component
public class SecurityConfig {
    /**
     * JWT令牌名称
     */
    private String tokenName = "Access-Token";

    /**
     * JWT令牌加密用的盐
     */
    private String tokenEncryptSalt = "MEICLOUD";

    /**
     * JWT令牌过期时间, 秒, 2592000=30天
     */
    private Long tokenExpireTimeInSecond = 2592000L;

    /**
     * JWT令牌刷新时间, tokenExpireTime - currentTime < tokenFreshInterval, 会重新刷新令牌
     */
    private Long tokenRefreshIntervalInSecond = 864000L;

    /**
     * 配置白名单（比如登录接口）
     */
    protected String[] permitUrls = new String[]{"/user/login", "/sentinel/**"};

    /**
     * 匿名访问的URL，即不用登录也可以访问（比如广告接口）
     */
    protected String[] anonymousUrls = new String[]{"/ad"};

    public SecurityConfig(String tokenName, String tokenEncryptSalt, Long tokenExpireTimeInSecond,
                          Long tokenRefreshIntervalInSecond, String[] permitUrls, String[] anonymousUrls) {
        this.tokenName = tokenName;
        this.tokenEncryptSalt = tokenEncryptSalt;
        this.tokenExpireTimeInSecond = tokenExpireTimeInSecond;
        this.tokenRefreshIntervalInSecond = tokenRefreshIntervalInSecond;
        this.permitUrls = permitUrls;
        this.anonymousUrls = anonymousUrls;
    }

    public SecurityConfig() {
    }

    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    public String getTokenEncryptSalt() {
        return tokenEncryptSalt;
    }

    public void setTokenEncryptSalt(String tokenEncryptSalt) {
        this.tokenEncryptSalt = tokenEncryptSalt;
    }

    public Long getTokenExpireTimeInSecond() {
        return tokenExpireTimeInSecond;
    }

    public void setTokenExpireTimeInSecond(Long tokenExpireTimeInSecond) {
        this.tokenExpireTimeInSecond = tokenExpireTimeInSecond;
    }

    public Long getTokenRefreshIntervalInSecond() {
        return tokenRefreshIntervalInSecond;
    }

    public void setTokenRefreshIntervalInSecond(Long tokenRefreshIntervalInSecond) {
        this.tokenRefreshIntervalInSecond = tokenRefreshIntervalInSecond;
    }

    public String[] getPermitUrls() {
        return permitUrls;
    }

    public void setPermitUrls(String[] permitUrls) {
        this.permitUrls = permitUrls;
    }

    public String[] getAnonymousUrls() {
        return anonymousUrls;
    }

    public void setAnonymousUrls(String[] anonymousUrls) {
        this.anonymousUrls = anonymousUrls;
    }
}
