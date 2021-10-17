package com.zhou.shop.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.entity.User;

import java.io.Serializable;
import java.util.List;

/**
 * 服务类
 *
 * @author 周雄
 * @since 2021-06-24
 */
public interface IUserService extends IService<User> {
    /**
     * 新增用户
     *
     * @param entity 用户对象
     * @return 布尔值
     */
    @Override
    boolean save(User entity);

    /**
     * 按id删除用户
     *
     * @param id 用户id
     * @return 布尔值
     */
    @Override
    boolean removeById(Serializable id);

    /**
     * 按id修改用户信息
     *
     * @param entity 用户对象
     * @return 布尔值
     */
    @Override
    boolean updateById(User entity);

    /**
     * 按id查询用户
     *
     * @param id 用户id
     * @return 用户对象
     */
    @Override
    User getById(Serializable id);

    /**
     * 查询全部用户
     *
     * @param queryWrapper 查询构造条件
     * @return 数组，全部用户
     */
    @Override
    List<User> list(Wrapper<User> queryWrapper);
}
