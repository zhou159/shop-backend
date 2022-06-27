package com.zhou.shop.apiServer.service.impl.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.entity.user.User;
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

    private static final String VERIFY_CODE = "VerifyCode";
    private final UserMapper userMapper;
    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
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
        user.setUserId(userId);
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
}
