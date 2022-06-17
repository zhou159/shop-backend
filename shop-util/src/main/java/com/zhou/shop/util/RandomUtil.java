package com.zhou.shop.util;

import com.zhou.shop.common.enums.SourceEnum;

/** @author Administrator */
public class RandomUtil {
    /** 生成随机验证码(数字，字母) */
    public static String createRandom(int length, SourceEnum sources, int bound) {
        java.util.Random random = new java.util.Random(System.currentTimeMillis());
        StringBuffer randomCode = new StringBuffer();
        // 循环伪随机生成length个字符
        for (int j = 0; j < length; j++) {
            randomCode.append(sources.getSources().charAt(random.nextInt(bound)) + "");
        }
        return randomCode.toString();
    }
}
