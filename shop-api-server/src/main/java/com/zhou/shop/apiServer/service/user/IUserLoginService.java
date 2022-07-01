package com.zhou.shop.apiServer.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.api.dto.UserLoginDTO;
import com.zhou.shop.api.entity.user.UserLogin;
import com.zhou.shop.api.vo.user.UserForgetPasswordVO;
import com.zhou.shop.api.vo.user.UserModifyPasswordVO;
import com.zhou.shop.api.vo.user.login.UserLoginUuidVO;
import com.zhou.shop.api.vo.user.login.UserLoginVO;
import com.zhou.shop.api.vo.user.register.UserRegisterVO;
import com.zhou.shop.common.RestObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author 周雄 @Date 2022/3/14 17:41 @Description
 */
public interface IUserLoginService extends IService<UserLogin> {

    /**
     * 用户登录
     *
     * @param userLoginVo 前端登录对象
     * @param request 请求
     * @return 登录后用户信息
     */
    RestObject<UserLoginDTO> login(UserLoginVO userLoginVo, HttpServletRequest request);

    /**
     * 用户名方式注册
     *
     * @param userRegisterVO 前端用户注册对象
     * @return 注册信息
     */
    RestObject<String> register(UserRegisterVO userRegisterVO);

    /**
     * 忘记密码
     *
     * @param userForgetPasswordVO 前端传入对象
     * @return 找回密码信息
     */
    RestObject<String> forgetPassword(UserForgetPasswordVO userForgetPasswordVO);

    /**
     * 修改密码
     *
     * @param userModifyPasswordVO 前端传入对象
     * @return 修改成功与否
     */
    RestObject<String> modifyPassword(UserModifyPasswordVO userModifyPasswordVO);

    /**
     * 生成验证码
     *
     * @param userLoginUuidVO 前端传入包含uuid对象
     * @param response http响应
     */
    void verifyCode(@Valid UserLoginUuidVO userLoginUuidVO, HttpServletResponse response);

    /**
     * 邮箱验证码
     * @param uuid uuid
     * @param mail 邮箱号
     */
    void mailVerifyCode(String uuid,String mail);
}
