package com.zhou.shop.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.zhou.shop.entity.User;
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
public interface IUserService extends IService<User> {
    @Override
    boolean save(User entity);

    @Override
    boolean removeById(Serializable id);

    @Override
    boolean updateById(User entity);

    @Override
    User getById(Serializable id);

    @Override
    List<User> list(Wrapper<User> queryWrapper);


}
