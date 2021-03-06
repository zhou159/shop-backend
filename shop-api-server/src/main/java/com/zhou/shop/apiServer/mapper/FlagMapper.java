package com.zhou.shop.apiServer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.shop.api.entity.Flag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Mapper 接口
 *
 * @author 周雄
 * @since 2021-06-24
 */
@Mapper
public interface FlagMapper extends BaseMapper<Flag> {
    /**
     * 根据标签名查找标签
     *
     * @param flagName 标签名
     * @return 标签对象
     */
    Flag retrieveByFlagName(@Param("flagName") String flagName);
}
