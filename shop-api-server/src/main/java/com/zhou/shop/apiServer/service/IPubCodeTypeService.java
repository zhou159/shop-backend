package com.zhou.shop.apiServer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.api.entity.PubCodeType;
import com.zhou.shop.common.RestObject;

import java.util.List;

/**
 * @author zhouxiong
 * @version v0.1
 * @since 2022/7/18 15:24
 */
public interface IPubCodeTypeService extends IService<PubCodeType> {
    /**
     * 查询全部目标类别
     * @return 码表类别集合
     */
    RestObject<List<PubCodeType>> getAllPubCodeType();

    RestObject<String> createPubCodeType(PubCodeType pubCodeType);
}
