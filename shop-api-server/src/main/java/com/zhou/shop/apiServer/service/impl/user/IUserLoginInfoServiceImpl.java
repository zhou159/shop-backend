package com.zhou.shop.apiServer.service.impl.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.entity.user.UserLoginInfo;
import com.zhou.shop.apiServer.mapper.user.UserLoginInfoMapper;
import com.zhou.shop.apiServer.service.user.IUserLoginInfoService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【user_login_info】的数据库操作Service实现
* @createDate 2022-07-01 16:31:52
*/
@Service
public class IUserLoginInfoServiceImpl extends ServiceImpl<UserLoginInfoMapper, UserLoginInfo>
    implements IUserLoginInfoService {

}




