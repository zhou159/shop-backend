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

    /**
     * 新增码表类别信息
     * @param pubCodeType 实体对象
     * @return 信息
     */
    RestObject<String> createPubCodeType(PubCodeType pubCodeType);

    /**
     * 更新码表类别信息
     * @return 信息
     */
    RestObject<String> updatePubCodeType(PubCodeType pubCodeType);

    /**
     * 删除码表信息
     * @return 信息
     */
    RestObject<String> deletePubCodeType(PubCodeType pubCodeType);

    /**
     * 修改码表类别状态
     * @return 信息
     */
    RestObject<String> updateStatus(String pubCodeTypeId, Integer status);
}
