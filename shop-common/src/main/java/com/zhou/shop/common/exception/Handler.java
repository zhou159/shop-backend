package com.zhou.shop.common.exception;

import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
/** 表示这个Controller不处理http请求，只处理当其他controller抛出异常时，进行处理。 */
public class Handler {
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
}
