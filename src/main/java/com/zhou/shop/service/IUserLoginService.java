package com.zhou.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.entity.UserLogin;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.vo.UserLoginVo;

import javax.servlet.http.HttpSession;

/**
 * @author 周雄 @Date 2022/3/14 17:41 @Description
 */
public interface IUserLoginService extends IService<UserLogin> {

    /**
     * 用户登录
     *
     * @param userLoginVo 前端登录对象
     * @param session session
     * @return
     */
    RestObject<String> login(UserLoginVo userLoginVo, HttpSession session);

    /**
     * 用户名方式注册
     *
     * @param userVo 前端用户对象
     * @param session session
     * @return
     */
    RestObject<String> registerUsername(UserLoginVo userVo, HttpSession session);
}
