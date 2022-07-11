package com.zhou.shop.oss.minio;

import com.zhou.shop.common.exception.FileErrorException;
import io.minio.*;
import io.minio.errors.*;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.UUID;

/**
 * minio工具类
 *
 * @author zhouxiong
 * @since 2022.5.26 10:11:26
 * @description minion 工具类
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class MinioUtil {
    private static final Integer DEFAULT_EXPIRY_TIME = 7 * 24 * 3600;

    private MinioClient minioClient;

    private MinioClient getMinioClient() {
        if (Objects.nonNull(minioClient)) {
            return minioClient;
        } else {
            minioClient =
                    MinioClient.builder()
                            .endpoint(MinioConfig.END_POINT)
                            .credentials(MinioConfig.ACCESS_KEY, MinioConfig.SECRET_KEY)
                            .build();
        }
        return minioClient;
    }

    public static void main(String[] args) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        MinioClient minioClient = MinioClient.builder()
                .endpoint("http://114.116.11.39:9090")
                .credentials("admin", "13551420591")
                .build();
        minioClient.bucketExists(BucketExistsArgs.builder().bucket("shop").build());
    }

    /** 检测桶是否存在 */
    public boolean bucketExists() {
        boolean flag = false;
        try {
            flag =
                    getMinioClient()
                            .bucketExists(BucketExistsArgs.builder().bucket(MinioConfig.BUCKET_NAME).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean makeBucket() {
        boolean flag = bucketExists();
        if (!flag) {
            try {
                getMinioClient().makeBucket(MakeBucketArgs.builder().bucket(MinioConfig.BUCKET_NAME).build());
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
                                        .bucket(MinioConfig.BUCKET_NAME)
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
                                                .bucket(MinioConfig.BUCKET_NAME)
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
        StringBuilder url = new StringBuilder(MinioConfig.MINIO_URL);
        if (flag) {
            try {
                GetObjectResponse object =
                        getMinioClient()
                                .getObject(
                                        GetObjectArgs.builder()
                                                .bucket(MinioConfig.BUCKET_NAME)
                                                .object(objectName)
                                                .build());
                url.append(object.object());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return url.toString();
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
            throw new FileErrorException("文件为空！");
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
            throw new FileErrorException("上传失败!");
        }
    }
}
