package com.zhou.shop.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.entity.Flag;

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
    /**
     * 按id删除标签
     * @param id 标签id
     * @return 标签对象
     */
    @Override
    boolean removeById(Serializable id);

    /**
     * 新增标签
     * @param entity 标签对象
     * @return 标签对象
     */
    @Override
    boolean save(Flag entity);

    /**
     * 按id修改标签数据
     * @param entity 标签对象
     * @return 标签对象
     */
    @Override
    boolean updateById(Flag entity);

    /**
     * 查询全部标签
     * @param queryWrapper 查询构造条件
     * @return 数组，全部标签
     */
    @Override
    List<Flag> list(Wrapper<Flag> queryWrapper);

    /**
     * 按id查询标签
     * @param id 标签id
     * @return 标签对象
     */
    @Override
    Flag getById(Serializable id);

}
