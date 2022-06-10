package com.zhou.shop.oss.minio;

import com.zhou.shop.common.BaseConstant;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 周雄
 * @description: minio配置类，注意下方Setter方法必须加，不然无法读取配置文件里的信息
 * @version: v1.0
 * @since 2022/6/9 16:01
 */
@Component
@ConfigurationProperties(prefix = "minio")
public class MinioConfig implements InitializingBean {
    public static String END_POINT;
    public static String BUCKET_NAME;
    public static String ACCESS_KEY;
    public static String SECRET_KEY;
    public static String MINIO_URL;
    private String endpoint;
    private String accessKey;
    private String secretKey;
    private String bucketName;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    @Override
    public void afterPropertiesSet() {
        END_POINT = endpoint;
        BUCKET_NAME = bucketName;
        ACCESS_KEY = accessKey;
        SECRET_KEY = secretKey;
        MINIO_URL = endpoint + BaseConstant.SLASH + bucketName + BaseConstant.SLASH;
    }
}
