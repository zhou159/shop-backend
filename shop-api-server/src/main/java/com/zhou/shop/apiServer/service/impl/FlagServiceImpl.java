package com.zhou.shop.apiServer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.entity.Flag;
import com.zhou.shop.apiServer.mapper.FlagMapper;
import com.zhou.shop.apiServer.service.IFlagService;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import com.zhou.shop.common.exception.ShopException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现类
 *
 * @author 周雄
 * @since 2021-06-24
 */
@Service
public class FlagServiceImpl extends ServiceImpl<FlagMapper, Flag> implements IFlagService {
    private final FlagMapper flagMapper;

    private final Logger log = LoggerFactory.getLogger(FlagServiceImpl.class);

    public FlagServiceImpl(FlagMapper flagMapper) {
        this.flagMapper = flagMapper;
    }

    @Override
    public RestObject<String> createFlag(Flag flag) {
        int insert = flagMapper.insert(flag);
        if (insert < 1) {
            log.warn("新增标签失败！");
            throw new ShopException("新增失败!");
        }
        log.info("新增标签成功！");
        return RestResponse.makeOkRsp("新增成功!");
    }

    @Override
    public RestObject<Flag> retrieveByFlagId(String flagId) {
        return RestResponse.makeOkRsp(flagMapper.selectById(flagId));
    }

    @Override
    public RestObject<List<Flag>> retrieveAllFlag() {
        return RestResponse.makeOkRsp(flagMapper.selectList(null));
    }

    @Override
    public RestObject<String> updateFlagByFlagId(String flagId, Flag flag) {
        flag.setFlagId(flagId);
        int i = flagMapper.updateById(flag);
        if (i < 1) {
            log.warn("修改标签失败！标签id:" + flagId);
            throw new ShopException("修改失败！");
        }
        log.info("修改标签成功！标签id:" + flagId);
        return RestResponse.makeOkRsp("修改成功！");
    }

    @Override
    public RestObject<String> deleteFlagById(String flagId) {
        int i = flagMapper.deleteById(flagId);
        if (i < 1) {
            log.warn("删除标签失败！标签id:" + flagId);
            throw new ShopException("修改失败！");
        }
        log.info("删除标签成功！标签id:" + flagId);
        return RestResponse.makeOkRsp("删除成功！");
    }

    @Override
    public Flag retrieveByFlagName(String flagName) {
        return flagMapper.retrieveByFlagName(flagName);
    }
}
