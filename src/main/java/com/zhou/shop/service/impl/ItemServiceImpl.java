package com.zhou.shop.service.impl;

import com.zhou.shop.entity.Item;
import com.zhou.shop.mapper.ItemMapper;
import com.zhou.shop.service.IItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 周雄
 * @since 2021-06-24
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {


}
