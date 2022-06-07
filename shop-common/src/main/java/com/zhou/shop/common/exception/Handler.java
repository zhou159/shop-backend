package com.zhou.shop.common.exception;

import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
/**表示这个Controller不处理http请求，只处理当其他controller抛出异常时，进行处理。*/
public class Handler {
    @ExceptionHandler(ShopException.class) // 就是定义处理什么异常
    @ResponseBody
    @ResponseStatus(HttpStatus.OK) // 服务器的异常
    public RestObject<String> handlerShareException(Exception e) {
        return RestResponse.makeErrRsp(e.getMessage());
    }

    @ExceptionHandler(UserNotLoginException.class)  //就是定义处理什么异常
    @ResponseBody
    @ResponseStatus(HttpStatus.OK) //服务器的异常
    public RestObject<String> handlerUserNotLoginException(Exception e){
        return RestResponse.errRsp(403,"User Not Login!",e.getMessage());
    }

    @ExceptionHandler(Exception.class)  //就是定义处理什么异常
    @ResponseBody
    @ResponseStatus(HttpStatus.OK) //服务器的异常
    public RestObject<String> ExceptionHandler(Exception e){
        return RestResponse.makeErrRsp(e.getMessage());
    }

    @ExceptionHandler(PermissionException.class)  //就是定义处理什么异常
    @ResponseBody
    @ResponseStatus(HttpStatus.OK) //服务器的异常
    public RestObject<String> PermissionHandler(Exception e){
        return RestResponse.errRsp(402,"Permission Error",e.getMessage());
    }

    @ExceptionHandler(UserAccountException.class)  //就是定义处理什么异常
    @ResponseBody
    @ResponseStatus(HttpStatus.OK) //服务器的异常
    public RestObject<String> UserAccountHandler(Exception e){
        return RestResponse.errRsp(401,"User Account Error!",e.getMessage());
    }

}
