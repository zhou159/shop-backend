package com.zhou.shop.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.entity.SitcomNumber;

import java.io.Serializable;
import java.util.List;

/**
 * 服务类
 *
 * @author 周雄
 * @since 2021-08-21
 */
public interface ISitcomNumberService extends IService<SitcomNumber> {
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
    boolean save(SitcomNumber entity);

    /**
     * 按id修改标签数据
     *
     * @param entity 标签对象
     * @return 标签对象
     */
    @Override
    boolean updateById(SitcomNumber entity);

    /**
     * 查询全部标签
     *
     * @param queryWrapper 查询构造条件
     * @return 数组，全部标签
     */
    @Override
    List<SitcomNumber> list(Wrapper<SitcomNumber> queryWrapper);

    /**
     * 按id查询标签
     *
     * @param id 标签id
     * @return 标签对象
     */
    @Override
    SitcomNumber getById(Serializable id);

    /**
     * 根据连续剧id获取集数信息
     *
     * @param sitcomId 连续剧id
     * @return 集数信息数组
     */
    List<SitcomNumber> retrieveBySitcomId(String sitcomId);

    /**
     * 按集名查询集
     *
     * @param sitcomNumberName 集名
     * @return 集对象
     */
    List<SitcomNumber> retrieveBySitcomNumberName(String sitcomNumberName);

    /**
     * 根据连续剧id删除所有剧集
     * @param sitcomId 连续剧id
     * @return 整数
     */
    int deleteBySitcomId(String sitcomId);

}
