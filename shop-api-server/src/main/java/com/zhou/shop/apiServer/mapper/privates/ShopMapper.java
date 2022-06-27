package com.zhou.shop.apiServer.mapper.privates;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.shop.api.entity.privates.Shop;
import org.apache.ibatis.annotations.Mapper;

/**
 * Mapper 接口
 *
 * @author 周雄
 * @since 2021-06-24
 */
@Mapper
public interface ShopMapper extends BaseMapper<Shop> {
}
