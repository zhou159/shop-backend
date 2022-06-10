package com.zhou.shop.apiServer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.shop.api.entity.user.UserLogin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: 周雄
 * @Date: 2022/3/14 17:42
 * @Description:
 */
@Mapper
public interface UserLoginMapper extends BaseMapper<UserLogin> {
}
