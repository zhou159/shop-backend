package com.zhou.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.shop.dto.ItemDto;
import com.zhou.shop.entity.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper 接口
 *
 * @author 周雄
 * @since 2021-06-24
 */
@Mapper
public interface ItemMapper extends BaseMapper<Item> {

    List<ItemDto> retrieveAllItem();

    List<ItemDto> retrieveByItemName(@Param("itemName") String itemName);
}
