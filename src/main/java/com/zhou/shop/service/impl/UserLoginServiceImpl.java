package com.zhou.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.entity.UserLogin;
import com.zhou.shop.mapper.UserLoginMapper;
import com.zhou.shop.service.IUserLoginService;
import org.springframework.stereotype.Service;

/**
 * @author 周雄
 * @Date 2022/3/14 17:41
 * @Description
 */
@Service
public class UserLoginServiceImpl extends ServiceImpl<UserLoginMapper, UserLogin> implements IUserLoginService {}
