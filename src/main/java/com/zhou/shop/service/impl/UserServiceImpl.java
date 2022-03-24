package com.zhou.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.entity.User;
import com.zhou.shop.mapper.UserMapper;
import com.zhou.shop.service.IUserService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * 服务实现类
 *
 * @author 周雄
 * @since 2021-06-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public boolean save(User entity) {
        return super.save(entity);
    }

    @Override
    public boolean removeById(User entity) {
        return super.removeById(entity);
    }

    @Override
    public boolean updateById(User entity) {
        return super.updateById(entity) ;
    }

    @Override
    public List<User> list(Wrapper<User> queryWrapper){
        return super.list(queryWrapper);
    }

    @Override
    public User getById(Serializable id){
        return super.getById(id);
    }
}
