package com.zhou.shop.common.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
/** 表示这个Controller不处理http请求，只处理当其他controller抛出异常时，进行处理。 */
public class Handler {
    Logger logger = LoggerFactory.getLogger(Handler.class);

    @ExceptionHandler(ShopException.class) // 就是定义处理什么异常
    @ResponseBody
    @ResponseStatus(HttpStatus.OK) // 服务器的异常
    public RestObject<String> handlerShareException(Exception e) {
        return RestResponse.makeErrRsp(e.getMessage());
    }

    @ExceptionHandler(UserNotLoginException.class) // 就是定义处理什么异常
    @ResponseBody
    @ResponseStatus(HttpStatus.OK) // 服务器的异常
    public RestObject<String> handlerUserNotLoginException(Exception e) {
        return RestResponse.errRsp(403, "User Not Login, Please Login!", e.getMessage());
    }

    @ExceptionHandler(Exception.class) // 就是定义处理什么异常
    @ResponseBody
    @ResponseStatus(HttpStatus.OK) // 服务器的异常
    public RestObject<String> handlerException(Exception e) {
        return RestResponse.makeErrRsp(e.getMessage());
    }

    @ExceptionHandler(PermissionException.class) // 就是定义处理什么异常
    @ResponseBody
    @ResponseStatus(HttpStatus.OK) // 服务器的异常
    public RestObject<String> handlerPermission(Exception e) {
        return RestResponse.errRsp(402, "Permission Error", e.getMessage());
    }

    @ExceptionHandler(UserAccountException.class) // 就是定义处理什么异常
    @ResponseBody
    @ResponseStatus(HttpStatus.OK) // 服务器的异常
    public RestObject<String> handlerUserAccountException(Exception e) {
        return RestResponse.errRsp(401, "User Account Error!", e.getMessage());
    }

    @ExceptionHandler(FileErrorException.class) // 就是定义处理什么异常
    @ResponseBody
    @ResponseStatus(HttpStatus.OK) // 服务器的异常
    public RestObject<String> handlerFileErrorException(Exception e) {
        return RestResponse.errRsp(
                700, "File Type Error Or Is Empty! Please Check Out It!", e.getMessage());
    }

    @ExceptionHandler(RedisException.class) // 就是定义处理什么异常
    @ResponseBody
    @ResponseStatus(HttpStatus.OK) // 服务器的异常
    public RestObject<String> handlerRedisException(Exception e) {
        return RestResponse.errRsp(1000, "Redis Error!", e.getMessage());
    }

    @ExceptionHandler(ObjectFieldEmptyException.class) // 就是定义处理什么异常
    @ResponseBody
    @ResponseStatus(HttpStatus.OK) // 服务器的异常
    public RestObject<String> handlerObjectFieldEmptyException(Exception e) {
        return RestResponse.errRsp(800, "NotNull Filed Is Empty!", e.getMessage());
    }

    /**
     * 自定义valid抛出的异常
     *
     * @param e 数据校验异常
     * @return 将valid注解中的值加入自定义返回对象并返回给请求接口者
     */
    @ExceptionHandler(BindException.class) // 就是定义处理什么异常
    @ResponseBody
    @ResponseStatus(HttpStatus.OK) // 服务器的异常
    public RestObject<String> handlerBindException(BindException e) {
        final StringBuilder stringBuilder = new StringBuilder();
        final BindingResult bindingResult = e.getBindingResult();
        for (ObjectError allError : bindingResult.getAllErrors()) {
            stringBuilder.append(allError.getDefaultMessage());
        }
        logger.error("数据校验发生异常：{}", stringBuilder);
        return RestResponse.errRsp(405, "Parameter Error!", stringBuilder.toString());
    }

    @ExceptionHandler(NotLoginException.class) // 就是定义处理什么异常
    @ResponseBody
    @ResponseStatus(HttpStatus.OK) // 服务器的异常
    public RestObject<String> handlerNotLoginException(NotLoginException e) {
        logger.error("登录异常：{}",e.getMessage());
        return RestResponse.errRsp(500, "Login Error!", e.getMessage());
    }

    @ExceptionHandler(NotRoleException.class) // 就是定义处理什么异常
    @ResponseBody
    @ResponseStatus(HttpStatus.OK) // 服务器的异常
    public RestObject<String> handlerNotRoleException(NotRoleException e) {
        logger.error("账号没有赋予此角色：{}",e.getRole());
        return RestResponse.errRsp(500, "Role Error!", String.format("账号没有此角色:%s",e.getRole()));
    }

    @ExceptionHandler(NotPermissionException.class) // 就是定义处理什么异常
    @ResponseBody
    @ResponseStatus(HttpStatus.OK) // 服务器的异常
    public RestObject<String> handlerNotPermissionException(NotPermissionException e) {
        logger.error("账号没有赋予此权限：{}",e.getPermission());
        return RestResponse.errRsp(500, "Permission Error!", String.format("账号没有此权限:%s",e.getPermission()));
    }

    @ExceptionHandler(CheckCodeErrorException.class) // 就是定义处理什么异常
    @ResponseBody
    @ResponseStatus(HttpStatus.OK) // 服务器的异常
    public RestObject<String> handlerCheckCodeErrorException(CheckCodeErrorException e) {
        return RestResponse.errRsp(500, "CheckCode Error!", e.getMessage());
    }
}
