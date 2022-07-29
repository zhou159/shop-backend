package com.zhou.shop.apiServer.service.impl.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.entity.user.User;
import com.zhou.shop.api.entity.user.UserLogin;
import com.zhou.shop.api.vo.user.UserBindEmailVO;
import com.zhou.shop.api.vo.user.UserModifyEmailVO;
import com.zhou.shop.apiServer.common.CommonMethodStatic;
import com.zhou.shop.apiServer.common.CommonMethods;
import com.zhou.shop.apiServer.mapper.user.UserLoginMapper;
import com.zhou.shop.apiServer.mapper.user.UserMapper;
import com.zhou.shop.apiServer.service.user.IUserService;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import com.zhou.shop.common.exception.ShopException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现类
 *
 * @author 周雄
 * @since 2021-06-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private final UserMapper userMapper;
    private final UserLoginMapper userLoginMapper;
    private final CommonMethods commonMethods;
    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(
            UserMapper userMapper, UserLoginMapper userLoginMapper, CommonMethods commonMethods) {
        this.userMapper = userMapper;
        this.userLoginMapper = userLoginMapper;
        this.commonMethods = commonMethods;
    }

    @Override
    public RestObject<String> createUser(User user) {
        int insert = userMapper.insert(user);
        if (insert < 1) {
            log.warn("新增用户失败！");
            throw new ShopException("新增失败！");
        }
        log.info("新增用户成功！");
        return RestResponse.makeOkRsp("新增成功!");
    }

    @Override
    public RestObject<User> retrieveByUserId(String userId) {
        return RestResponse.makeOkRsp(userMapper.selectById(userId));
    }

    @Override
    public RestObject<List<User>> retrieveAllUser() {
        return RestResponse.makeOkRsp(userMapper.selectList(null));
    }

    @Override
    public RestObject<String> updateUserByUserId(User user) {
        String userId = user.getUserId();
        int i = userMapper.updateById(user);
        if (i < 1) {
            log.warn("修改用户失败！用户id：" + userId);
            throw new ShopException("修改失败！");
        }
        log.info("修改用户成功！用户id：" + userId);
        return RestResponse.makeOkRsp("修改成功！");
    }

    @Override
    public RestObject<String> deleteUserById(String userId) {
        int i = userMapper.deleteById(userId);
        if (i < 1) {
            log.warn("删除用户失败！用户id：" + userId);
            throw new ShopException("删除失败！");
        }
        log.info("删除用户成功！用户id：" + userId);
        return RestResponse.makeOkRsp("删除成功！");
    }

    /**
     * @param userBindEmailVO 用户绑定邮箱前端对象
     * @return
     */
    @Override
    public RestObject<String> bindEmail(UserBindEmailVO userBindEmailVO) {
        String userId = userBindEmailVO.getUserId();
        CommonMethodStatic.checkUserId(userId, "用户账号信息错误!");

        commonMethods.checkVerifyCode(userBindEmailVO.getUuid(), userBindEmailVO.getCheckCode());

        final UserLogin userLogin =
                userLoginMapper.selectOne(
                        new LambdaQueryWrapper<UserLogin>()
                                .eq(UserLogin::getUserAccount, userBindEmailVO.getMail()));

        CommonMethodStatic.checkObjectNull(userLogin, "该邮箱已被使用!请更换!");

        final List<UserLogin> userLogins =
                userLoginMapper.selectList(
                        new LambdaQueryWrapper<UserLogin>().eq(UserLogin::getUserId, userId));

        final UserLogin userLogin1 = new UserLogin();
        userLogin1.setUserAccount(userBindEmailVO.getMail());
        userLogin1.setUserPassword(userLogins.get(0).getUserPassword());
        userLogin1.setUserId(userId);
        final int insert = userLoginMapper.insert(userLogin1);

        return insert > 0 ? RestResponse.makeOkRsp("绑定成功!") : RestResponse.makeErrRsp("绑定失败!");
    }

    /**
     * @param userModifyEmailVO 前端用户更换邮箱对象
     * @return 信息
     */
    @Override
    public RestObject<String> modifyEmail(UserModifyEmailVO userModifyEmailVO) {
        String userId = userModifyEmailVO.getUserId();
        CommonMethodStatic.checkUserId(userId, "用户账号信息错误!");

        // 验证码校验
        commonMethods.checkVerifyCode(
                userModifyEmailVO.getUuid(), userModifyEmailVO.getCheckCode());

        // 密码校验
        final UserLogin userLogin =
                userLoginMapper.selectOne(
                        new LambdaQueryWrapper<UserLogin>()
                                .eq(UserLogin::getUserAccount, userModifyEmailVO.getOldMail())
                                .eq(
                                        UserLogin::getUserPassword,
                                        CommonMethodStatic.passwordEncrypt(
                                                userModifyEmailVO.getUserPassword())));
        CommonMethodStatic.checkObjectNotNull(userLogin, "信息输入有误!");

        // 更改信息
        final int update =
                userLoginMapper.update(
                        null,
                        new LambdaUpdateWrapper<UserLogin>()
                                .set(UserLogin::getUserAccount, userModifyEmailVO.getNewMail())
                                .eq(UserLogin::getUserId, userId)
                                .eq(UserLogin::getUserAccount, userModifyEmailVO.getOldMail()));

        return update > 0 ? RestResponse.makeOkRsp("修改成功!") : RestResponse.makeErrRsp("修改失败!");
    }
}
