package com.zhou.shop.apiServer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.api.entity.Flag;
import com.zhou.shop.common.RestObject;

import java.util.List;

/**
 * 服务类
 *
 * @author 周雄
 * @since 2021-06-24
 */
public interface IFlagService extends IService<Flag> {

    /**
     * 新增
     *
     * @param flag 对象
     * @return
     */
    RestObject<String> createFlag(Flag flag);

    /**
     * 根据id查询
     *
     * @param flagId id
     * @return
     */
    RestObject<Flag> retrieveByFlagId(String flagId);

    /**
     * 查询全部
     *
     * @return
     */
    RestObject<List<Flag>> retrieveAllFlag();

    /**
     * 根据id修改
     *
     * @param flagId id
     * @param flag 对象
     * @return
     */
    RestObject<String> updateFlagByFlagId(String flagId, Flag flag);

    /**
     * 根据id删除
     *
     * @param flagId id
     * @return
     */
    RestObject<String> deleteFlagById(String flagId);

    /**
     * 根据标签名查找标签
     * @param flagName 标签名
     * @return 标签对象
     */
    Flag retrieveByFlagName(String flagName);
}
