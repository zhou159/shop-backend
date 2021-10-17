package com.zhou.shop.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.entity.Sitcom;

import java.io.Serializable;
import java.util.List;

/**
 * 服务类
 *
 * @author 周雄
 * @since 2021-08-21
 */
public interface ISitcomService extends IService<Sitcom> {
    /**
     * 按id删除标签
     *
     * @param id 标签id
     * @return 标签对象
     */
    @Override
    boolean removeById(Serializable id);

    /**
     * 新增标签
     *
     * @param entity 标签对象
     * @return 标签对象
     */
    @Override
    boolean save(Sitcom entity);

    /**
     * 按id修改标签数据
     *
     * @param entity 标签对象
     * @return 标签对象
     */
    @Override
    boolean updateById(Sitcom entity);

    /**
     * 查询全部标签
     *
     * @param queryWrapper 查询构造条件
     * @return 数组，全部标签
     */
    @Override
    List<Sitcom> list(Wrapper<Sitcom> queryWrapper);

    /**
     * 按id查询标签
     *
     * @param id 标签id
     * @return 标签对象
     */
    @Override
    Sitcom getById(Serializable id);
}
