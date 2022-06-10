package com.zhou.shop.apiServer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.api.entity.user.User;
import com.zhou.shop.common.RestObject;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 服务类
 *
 * @author 周雄
 * @since 2021-06-24
 */
public interface IUserService extends IService<User> {
    /**
     * 新增
     *
     * @param user 对象
     * @return
     */
    RestObject<String> createUser(User user);

    /**
     * 根据id查询
     *
     * @param userId id
     * @return
     */
    RestObject<User> retrieveByUserId(String userId);

    /**
     * 查询全部
     *
     * @return
     */
    RestObject<List<User>> retrieveAllUser();

    /**
     * 根据id更新
     *
     * @param userId id
     * @param user 对象
     * @return
     */
    RestObject<String> updateUserByUserId(String userId, User user);

    /**
     * 根据id删除
     *
     * @param userId id
     * @return
     */
    RestObject<String> deleteUserById(String userId);

    /**
     * 生成验证码
     *
     * @param session
     * @param response
     */
    void verifyCode(HttpSession session, HttpServletResponse response);
}
