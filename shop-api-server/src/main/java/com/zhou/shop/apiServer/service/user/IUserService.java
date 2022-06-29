package com.zhou.shop.apiServer.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.api.entity.user.User;
import com.zhou.shop.api.vo.user.UserBindEmailVO;
import com.zhou.shop.api.vo.user.UserModifyEmailVO;
import com.zhou.shop.common.RestObject;

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
     * @param user 对象
     * @return
     */
    RestObject<String> updateUserByUserId(User user);

    /**
     * 根据id删除
     *
     * @param userId id
     * @return
     */
    RestObject<String> deleteUserById(String userId);

    /**
     * 绑定邮箱
     * @param userBindEmailVO 用户绑定邮箱前端对象
     * @return
     */
    RestObject<String> bindEmail(UserBindEmailVO userBindEmailVO);

    /**
     * 更换邮箱
     * @param userModifyEmailVO 前端用户更换邮箱对象
     * @return 信息
     */
    RestObject<String> modifyEmail(UserModifyEmailVO userModifyEmailVO);
}
