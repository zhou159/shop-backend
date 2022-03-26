package com.zhou.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.entity.Flag;

/**
 * 服务类
 *
 * @author 周雄
 * @since 2021-06-24
 */
public interface IFlagService extends IService<Flag> {
    /**
     * 根据标签名查找标签
     *
     * @param flagName 标签名
     * @return 标签对象
     */
    Flag retrieveByFlagName(String flagName);
}
