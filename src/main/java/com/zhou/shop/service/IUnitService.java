package com.zhou.shop.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.entity.Unit;

import java.io.Serializable;
import java.util.List;

/**
 * 服务类
 *
 * @author 周雄
 * @since 2021-07-20
 */
public interface IUnitService extends IService<Unit> {

    /**
     * 新增单位
     *
     * @param entity 单位对象
     * @return 布尔值
     */
    @Override
    boolean save(Unit entity);

    /**
     * 按id删除单位
     *
     * @param id 单位id
     * @return 布尔值
     */
    @Override
    boolean removeById(Serializable id);

    /**
     * 按id修改单位信息
     *
     * @param entity 单位对象
     * @return 布尔值
     */
    @Override
    boolean updateById(Unit entity);

    /**
     * 按id查询单位
     *
     * @param id 单位id
     * @return 单位对象
     */
    @Override
    Unit getById(Serializable id);

    /**
     * 查询全部单位
     *
     * @param queryWrapper 查询构造条件
     * @return 数组，全部单位
     */
    @Override
    List<Unit> list(Wrapper<Unit> queryWrapper);

    /**
     * 按单位名查询单位
     *
     * @param unitName 单位名
     * @return 单位对象
     */
    List<Unit> retrieveByUnitName(String unitName);
}
