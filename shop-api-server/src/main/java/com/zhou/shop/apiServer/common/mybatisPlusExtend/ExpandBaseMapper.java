package com.zhou.shop.apiServer.common.mybatisPlusExtend;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Collection;

/**
 * @author zhouxiong
 * @version v0.1
 * @since 2022/7/6 11:32
 */
public interface ExpandBaseMapper<T> extends BaseMapper<T> {
    /**
     * 批量插入 仅适用于mysql
     *
     * @param entityList 实体列表
     */
    Integer insertBatchSomeColumn(Collection<T> entityList);
}
