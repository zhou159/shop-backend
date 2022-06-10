package com.zhou.shop.util;

import com.zhou.shop.common.exception.RedisException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 周雄
 * @description:
 * @version: v1.0 创建redis工具类并完成部分方法
 * @since 2022/6/10 17:05
 */
@Component
public class RedisUtil {
    @Autowired
    @Resource(name = "myRedisTemplate")
    private RedisTemplate myRedisTemplate;

    /**
     * 设置一个String类键
     *
     * @param key:key
     * @param value:value
     */
    public String set(String key, Object value) {
        try {
            myRedisTemplate.opsForValue().set(key, value);
            return "添加成功";
        } catch (Exception e) {
            e.printStackTrace();
            throw new RedisException("redis异常!" + e);
        }
    }

    /**
     * 设置一个带时间的String类键
     *
     * @param key:key
     * @param value:value
     * @param time:时间，单位（分）
     */
    public String setex(String key, Object value, Integer time) {
        try {
            myRedisTemplate.opsForValue().set(key, value, time, TimeUnit.MINUTES);
            return "添加成功";
        } catch (Exception e) {
            e.printStackTrace();
            throw new RedisException("redis异常!" + e);
        }
    }

    public String setex(String key, Object value, Integer time, TimeUnit unit) {
        try {
            myRedisTemplate.opsForValue().set(key, value, time, unit);
            return "添加成功";
        } catch (Exception e) {
            e.printStackTrace();
            throw new RedisException("redis异常!" + e);
        }
    }

    /**
     * 获取String类型键的值
     *
     * @param key
     * @return
     */
    public Object get(String key) {
        try {
            Object o = myRedisTemplate.opsForValue().get(key);
            return o;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RedisException("redis异常!" + e);
        }
    }

    /**
     * 在数组尾部加入元素
     *
     * @param key
     * @param value
     */
    public void rPush(String key, Object value) {
        try {
            myRedisTemplate.opsForList().rightPush(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RedisException("redis异常!" + e);
        }
    }

    /**
     * 查询redis中指定list类型键的全部元素
     *
     * @param key
     * @return
     */
    public List lrangeAll(Object key) {
        try {
            List list = myRedisTemplate.opsForList().range(key, 0, -1);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RedisException("redis异常!" + e);
        }
    }

    /**
     * 从redis中删除list类型键指定数量value
     *
     * @param key
     * @param value
     */
    public void lrem(Object key, Object value) {
        try {
            myRedisTemplate.opsForList().remove(key, 1, value);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RedisException("redis异常!" + e);
        }
    }

    /**
     * 从redis中移除键
     *
     * @param key
     * @return
     */
    public boolean del(Object key) {
        try {
            Boolean delete = myRedisTemplate.delete(key);
            return delete;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RedisException("redis异常!" + e);
        }
    }
}
