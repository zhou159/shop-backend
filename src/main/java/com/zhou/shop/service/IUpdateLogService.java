package com.zhou.shop.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.entity.UpdateLog;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 周雄
 * @since 2021-07-24
 */
public interface IUpdateLogService extends IService<UpdateLog> {
    @Override
    boolean save(UpdateLog entity);

    @Override
    boolean removeById(Serializable id);

    @Override
    boolean updateById(UpdateLog entity);

    @Override
    UpdateLog getById(Serializable id);

    @Override
    List<UpdateLog> list(Wrapper<UpdateLog> queryWrapper);


}
