package com.buydeem.booksserver.config;

import com.buydeem.common.dto.Response;
import com.buydeem.common.error.BaseException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BaseException.class)
    public Response<?> baseException(BaseException e) {
        return Response.error(e.getMessage());
    }

    @ExceptionHandler(value = BindException.class)
    public Response<?> bindException(BindException e) {
        String errorInfo = e.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(","));
        return Response.error(errorInfo);
    }

}
