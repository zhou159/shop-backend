package com.zhou.shop.apiServer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.api.entity.PubCode;
import com.zhou.shop.common.RestObject;

import java.util.List;

/**
 * @author 周雄
 * @date 2022/5/17 18:24
 * @description
 */
public interface IPubCodeService extends IService<PubCode> {
    /**
     * 根据classId查询
     *
     * @param pubCodeType 类别代码
     * @return 根据类别代码查询出的码表集合
     */
    RestObject<List<PubCode>> retrievePubCodeByType(String pubCodeType);

    /**
     * 查询所有码表
     * @return 码表集合
     */
    RestObject<List<PubCode>> retrieveAllPubCode();

    /**
     * 新增码表
     * @param pubCode 码表对象
     * @return 信息
     */
    RestObject<String> createPubCode(PubCode pubCode);

    /**
     * 修改码表
     * @param pubCode 码表对象
     * @return 信息
     */
    RestObject<String> updatePubCode(PubCode pubCode);

    /**
     * 删除码表
     * @param pubCodeId 码表id
     * @return 信息
     */
    RestObject<String> deletePubCode(String pubCodeId);

}
