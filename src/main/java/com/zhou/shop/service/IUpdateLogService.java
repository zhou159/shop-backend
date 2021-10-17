package com.zhou.shop.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.entity.UpdateLog;

import java.io.Serializable;
import java.util.List;

/**
 * 服务类
 *
 * @author 周雄
 * @since 2021-07-24
 */
public interface IUpdateLogService extends IService<UpdateLog> {
    /**
     * 新增更新日志
     *
     * @param entity 更新日志对象
     * @return 布尔值
     */
    @Override
    boolean save(UpdateLog entity);

    /**
     * 按id删除更新日志
     *
     * @param id 更新日志id
     * @return 布尔值
     */
    @Override
    boolean removeById(Serializable id);

    /**
     * 按id修改更新日志对象
     *
     * @param entity 更新日志对象
     * @return 布尔值
     */
    @Override
    boolean updateById(UpdateLog entity);

    /**
     * 按id查询更新日志
     *
     * @param id 更新日志id
     * @return 更新日志对象
     */
    @Override
    UpdateLog getById(Serializable id);

    /**
     * 查询全部更新日志
     *
     * @param queryWrapper 查询构造条件
     * @return 数组，全部更新日志
     */
    @Override
    List<UpdateLog> list(Wrapper<UpdateLog> queryWrapper);
}
