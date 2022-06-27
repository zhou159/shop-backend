package com.zhou.shop.apiServer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.shop.api.entity.Flag;
import org.apache.ibatis.annotations.Mapper;

/**
 * Mapper 接口
 *
 * @author 周雄
 * @since 2021-06-24
 */
@Mapper
public interface FlagMapper extends BaseMapper<Flag> {
}
