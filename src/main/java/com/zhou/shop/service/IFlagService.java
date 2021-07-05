package com.zhou.shop.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.zhou.shop.entity.Flag;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 周雄
 * @since 2021-06-24
 */
public interface IFlagService extends IService<Flag> {
    @Override
    boolean removeById(Serializable id);

    @Override
    boolean save(Flag entity);

    @Override
    boolean updateById(Flag entity);

    @Override
    List<Flag> list(Wrapper<Flag> queryWrapper);

    @Override
    Flag getById(Serializable id);

}
