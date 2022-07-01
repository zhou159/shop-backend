package com.zhou.shop.apiServer.mapper.user;

import com.zhou.shop.api.entity.user.UserLoginInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【user_login_info】的数据库操作Mapper
* @createDate 2022-07-01 16:31:52
* @Entity com.zhou.shop.api.entity.user.UserLoginInfo
*/
@Mapper
public interface UserLoginInfoMapper extends BaseMapper<UserLoginInfo> {

}




