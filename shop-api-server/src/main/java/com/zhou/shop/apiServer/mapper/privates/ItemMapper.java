package com.zhou.shop.apiServer.mapper.privates;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.shop.api.dto.ItemDTO;
import com.zhou.shop.api.entity.privates.Item;
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

    List<ItemDTO> retrieveAllItem();

    List<ItemDTO> retrieveByItemName(@Param("itemName") String itemName);
}
