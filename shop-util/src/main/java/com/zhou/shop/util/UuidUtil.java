package com.zhou.shop.util;

import java.util.UUID;

/**
 * @author 周雄
 * @description:
 * @version: v1.0 创建工具类
 * @since 2022/6/10 16:37
 */
public class UuidUtil {

    /**
     * 获取uuid方法
     * @param uppercase 是否大写
     * @param existHyphen 是否保留-
     * @return uuid字符串
     * @version: v1.0
     */
    private static String getUuid(boolean uppercase, boolean existHyphen){
        if(uppercase && existHyphen){
            return UUID.randomUUID().toString().toUpperCase();
        }else if(uppercase){
            return UUID.randomUUID().toString().replace("-","").toUpperCase();
        }else if(existHyphen){
            return UUID.randomUUID().toString().replace("-","");
        }
        return UUID.randomUUID().toString();
    }

    /**
     * 默认不保留-，询问大小写
     * @param uppercase 是否大小写
     * @return uuid字符串
     */
    public static String getUuid(boolean uppercase){
        return getUuid(uppercase,false);
    }

    /**
     * 常用获取uuid方法，去除-，全部大写
     * @return uuid字符串
     */
    public static String getUuid(){
        return getUuid(true, false);
    }
}
