package com.zhou.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.entity.Flag;
import com.zhou.shop.mapper.FlagMapper;
import com.zhou.shop.service.IFlagService;
import org.springframework.stereotype.Service;

/**
 * 服务实现类
 *
 * @author 周雄
 * @since 2021-06-24
 */
@Service
public class FlagServiceImpl extends ServiceImpl<FlagMapper, Flag> implements IFlagService {
    final FlagMapper flagMapper;

    public FlagServiceImpl(FlagMapper flagMapper) {
        this.flagMapper = flagMapper;
    }

    @Override
    public Flag retrieveByFlagName(String flagName) {
        return flagMapper.retrieveByFlagName(flagName);
    }
}
