package com.zhou.shop.mapper;

import com.zhou.shop.dto.ItemDto;
import com.zhou.shop.entity.Shop;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 周雄
 * @since 2021-06-24
 */
@Mapper
public interface ShopMapper extends BaseMapper<Shop> {
    List<Shop> retrieveByShopName(@Param("shopName")String shopName);

}