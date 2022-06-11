package com.zhou.shop.apiServer.service.impl.privates;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.dto.ItemDTO;
import com.zhou.shop.api.entity.Flag;
import com.zhou.shop.api.entity.privates.Item;
import com.zhou.shop.api.vo.ItemVO;
import com.zhou.shop.apiServer.mapper.privates.ItemMapper;
import com.zhou.shop.apiServer.service.IFlagService;
import com.zhou.shop.apiServer.service.privates.IItemService;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import com.zhou.shop.common.exception.ShopException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 服务实现类
 *
 * @author 周雄
 * @since 2021-06-24
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {

    private final ItemMapper itemMapper;
    private final IFlagService iFlagService;

    private final Logger log = LoggerFactory.getLogger(ItemServiceImpl.class);

    public ItemServiceImpl(ItemMapper itemMapper, IFlagService iFlagService) {
        this.itemMapper = itemMapper;
        this.iFlagService = iFlagService;
    }

    @Override
    public RestObject<List<ItemDTO>> retrieveAllItem() {
        return RestResponse.makeOkRsp(itemMapper.retrieveAllItem());
    }

    @Override
    public RestObject<List<ItemDTO>> retrieveByItemName(String itemName) {

        return RestResponse.makeOkRsp(itemMapper.retrieveByItemName(itemName));
    }

    @Transactional(rollbackFor = ShopException.class)
    @Override
    public RestObject<String> createItem(ItemVO itemVo) {
        String flagName = itemVo.getFlagName();
        Flag flag = iFlagService.retrieveByFlagName(flagName);
        if (flag == null) {
            iFlagService.createFlag(new Flag().setFlagName(flagName));
        }
        String flagId = iFlagService.retrieveByFlagName(flagName).getFlagId();
        Item item = new Item();
        BeanUtils.copyProperties(itemVo, item);
        item.setFlagId(flagId).setItemCreateTime(LocalDateTime.now());
        int save = itemMapper.insert(item);
        if (save < 1) {
            log.warn("新增商品失败！");
            throw new ShopException("新增商品失败！");
        }
        log.info("新增商品成功！");
        return RestResponse.makeOkRsp("新增成功！");
    }

    @Override
    public RestObject<Item> retrieveByItemId(String itemId) {
        return RestResponse.makeOkRsp(itemMapper.selectById(itemId));
    }

    @Override
    public RestObject<String> updateItemByItemId(String itemId, ItemVO itemVo) {
        String flagName = itemVo.getFlagName();
        Flag flag = iFlagService.retrieveByFlagName(flagName);
        if (flag == null) {
            iFlagService.createFlag(new Flag().setFlagName(flagName));
        }
        String flagId = iFlagService.retrieveByFlagName(flagName).getFlagId();
        Item item = new Item();
        BeanUtils.copyProperties(itemVo, item);
        item.setFlagId(flagId).setItemId(itemId).setItemUpdateTime(LocalDateTime.now());
        int i = itemMapper.updateById(item);
        if (i < 1) {
            log.warn("修改物品信息失败！物品id:" + itemId);
            throw new ShopException("修改物品信息失败！");
        }
        log.info("修改物品信息成功！物品id:" + itemId);
        return RestResponse.makeOkRsp("修改成功！");
    }

    @Override
    public RestObject<String> deleteItemById(String itemId) {
        int i = itemMapper.deleteById(itemId);
        if (i < 1) {
            log.warn("删除物品失败！物品id：" + itemId);
            throw new ShopException("删除物品失败！");
        }
        log.info("删除物品成功！物品id：" + itemId);
        return RestResponse.makeOkRsp("删除成功！");
    }
}
