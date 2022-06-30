package com.zhou.shop.apiServer.service;

import com.alibaba.fastjson2.JSONObject;
import com.zhou.shop.common.RestObject;

import java.util.List;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0-2022/6/30 16:43-zhouxiong： 创建此类
 * @since 2022/6/30 16:43
 */
public interface CommonService {

    /**
     * 查询用户可访问的前端路径
     * @param userId 用户id
     * @return 路径列表
     */
    RestObject<List<JSONObject>> queryReferences(String userId);
}
