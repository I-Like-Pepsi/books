package com.buydeem.user.config;

import com.buydeem.common.dto.Response;
import com.buydeem.common.error.BaseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BaseException.class)
    public Response<?> baseException(BaseException e){
        return Response.error(e.getMessage());
    }

}
