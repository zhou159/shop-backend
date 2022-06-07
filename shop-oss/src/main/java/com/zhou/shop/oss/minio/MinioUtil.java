package com.zhou.shop.oss.minio;

import io.minio.*;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Objects;
import java.util.UUID;

/**
 * minio工具类
 *
 * @author Administrator
 */
@Component
public class MinioUtil {
    private static final Integer DEFAULT_EXPIRY_TIME = 7 * 24 * 3600;

    @ApiModelProperty("协议://域名(IP地址):端口号")
    @Value("${minio.endpoint}")
    private String endpoint;

    @Value("${minio.accessKey}")
    @ApiModelProperty("minio的登录名")
    private String accessKey;

    @Value("${minio.secretKey}")
    @ApiModelProperty("minio的密码")
    private String secretKey;

    @Value("${minio.bucketName}")
    private String bucketName;

    private MinioClient minioClient;

    private MinioClient getMinioClient() {
        if (Objects.nonNull(minioClient)) {
            return minioClient;
        } else {
            minioClient =
                    MinioClient.builder()
                            .endpoint(this.endpoint)
                            .credentials(this.accessKey, this.secretKey)
                            .build();
        }
        return minioClient;
    }

    /** 检测桶是否存在 */
    public boolean bucketExists() {
        boolean flag = false;
        try {
            flag =
                    getMinioClient()
                            .bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean makeBucket() {
        boolean flag = bucketExists();
        if (!flag) {
            try {
                getMinioClient().makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * 通过InputStream上传对象
     *
     * @param objectName 存储桶里的对象名称
     * @param stream 要上传的流
     * @return
     */
    public boolean putObject(String objectName, InputStream stream) {
        boolean flag = bucketExists();
        if (flag) {
            try {
                getMinioClient()
                        .putObject(
                                PutObjectArgs.builder()
                                        .bucket(bucketName)
                                        .object(objectName)
                                        .stream(stream, stream.available(), -1)
                                        .build());
            } catch (Exception e) {
                e.printStackTrace();
            }
            StatObjectResponse statObject = statObject(objectName);
            return statObject != null;
        }
        return false;
    }

    /**
     * 以流的形式获取一个文件对象
     *
     * @param bucketName 存储桶名称
     * @param objectName 存储桶里的对象名称
     * @return
     */
    public InputStream getObject(String bucketName, String objectName) {
        boolean flag = bucketExists();
        if (flag) {
            StatObjectResponse statObject = statObject(objectName);
            if (statObject != null) {
                InputStream stream = null;
                try {
                    stream =
                            getMinioClient()
                                    .getObject(
                                            GetObjectArgs.builder()
                                                    .bucket(bucketName)
                                                    .object(objectName)
                                                    .build());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return stream;
            }
        }
        return null;
    }

    /**
     * 获取对象的元数据
     *
     * @param objectName 存储桶里的对象名称
     * @return
     */
    public StatObjectResponse statObject(String objectName) {
        boolean flag = bucketExists();
        if (flag) {
            StatObjectResponse statObject = null;
            try {
                statObject =
                        getMinioClient()
                                .statObject(
                                        StatObjectArgs.builder()
                                                .bucket(bucketName)
                                                .object(objectName)
                                                .build());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return statObject;
        }
        return null;
    }

    /**
     * 文件访问路径
     *
     * @param objectName 存储桶里的对象名称
     * @return
     */
    public String getObjectUrl(String objectName) {
        boolean flag = bucketExists();
        String url = "";
        if (flag) {
            try {
                GetObjectResponse object =
                        getMinioClient()
                                .getObject(
                                        GetObjectArgs.builder()
                                                .bucket(bucketName)
                                                .object(objectName)
                                                .build());
                url = object.object();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return url;
    }

    /**
     * 文件访问路径
     *
     * @param file 上传的文件
     * @param folderName 文件夹名字
     * @return 文件访问路径
     */
    public String upload(MultipartFile file, String folderName) {
        if (file.isEmpty() || file.getSize() == 0) {
            return "文件为空";
        }
        try {
            if (!bucketExists()) {
                makeBucket();
            }
            String fileName = file.getOriginalFilename();
            Assert.notNull(fileName, "文件名不能为空！");
            String newName =
                    folderName
                            + "/"
                            + UUID.randomUUID().toString().replaceAll("-", "")
                            + fileName.substring(fileName.lastIndexOf("."));

            InputStream inputStream = file.getInputStream();
            putObject(newName, inputStream);
            inputStream.close();

            return getObjectUrl(newName);
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
    }
}
