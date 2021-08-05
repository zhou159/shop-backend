package com.zhou.shop.util;

import io.minio.MinioClient;
import io.minio.ObjectStat;
import io.minio.PutObjectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

/**
 * minio工具类
 * @author Administrator
 */
@Component
public class MinioUtil {
    private static final Integer DEFAULT_EXPIRY_TIME = 7 * 24 * 3600;
    @Autowired
    private MinioClient minioClient;

    @Value("${minio.bucketName}")
    private String bucketName;

    /**
     * 检测桶是否存在
     * @param bucketName 桶名称
     */
    public boolean bucketExists(String bucketName){
        boolean flag = false;
        try {
            flag = minioClient.bucketExists(bucketName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean makeBucket(String bucketName) {
        boolean flag = bucketExists(bucketName);
        if (!flag) {
            try {
                minioClient.makeBucket(bucketName);
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
     * @param bucketName 存储桶名称
     * @param objectName 存储桶里的对象名称
     * @param stream     要上传的流
     * @return
     */
    public boolean putObject(String bucketName, String objectName, InputStream stream) {
        boolean flag = bucketExists(bucketName);
        if (flag) {
            try {
                minioClient.putObject(bucketName, objectName, stream, new PutObjectOptions(stream.available(), -1));
            } catch (Exception e) {
                e.printStackTrace();
            }
            ObjectStat statObject = statObject(bucketName, objectName);
            return statObject != null && statObject.length() > 0;
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
        boolean flag = bucketExists(bucketName);
        if (flag) {
            ObjectStat statObject = statObject(bucketName, objectName);
            if (statObject != null && statObject.length() > 0) {
                InputStream stream = null;
                try {
                    stream = minioClient.getObject(bucketName, objectName);
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
     * @param bucketName 存储桶名称
     * @param objectName 存储桶里的对象名称
     * @return
     */
    public ObjectStat statObject(String bucketName, String objectName) {
        boolean flag = bucketExists(bucketName);
        if (flag) {
            ObjectStat statObject = null;
            try {
                statObject = minioClient.statObject(bucketName, objectName);
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
     * @param bucketName 存储桶名称
     * @param objectName 存储桶里的对象名称
     * @return
     */
    public String getObjectUrl(String bucketName, String objectName) {
        boolean flag = bucketExists(bucketName);
        String url = "";
        if (flag) {
            try {
                url = minioClient.getObjectUrl(bucketName, objectName);
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
     * @param foldername 文件夹名字
     * @return 文件访问路径
     */
    public String upload(MultipartFile file, String foldername) {
        if (file.isEmpty() || file.getSize() == 0) {
            return "文件为空";
        }
        try {
            if (!bucketExists(bucketName)) {
                makeBucket(bucketName);
            }
            String fileName = file.getOriginalFilename();
            String newName = foldername + "/" + UUID.randomUUID().toString().replaceAll("-", "")
                    + fileName.substring(fileName.lastIndexOf("."));

            InputStream inputStream = file.getInputStream();
            putObject(bucketName, newName, inputStream);
            inputStream.close();

            String url = getObjectUrl(bucketName, newName);
            return url;
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
    }
}
