package com.buydeem.common.dto;

import com.buydeem.common.constant.ResponseCode;
import lombok.Data;

/**
 * 通用的接口响应结果
 * @param <T>
 */
@Data
public class Response<T> {
    private String code;
    private String message;
    private T data;

    public Response() {
    }

    public Response(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Response<T> ok(T data){
        return new Response<>(ResponseCode.OK.getCode(), ResponseCode.OK.getMessage(), data);
    }

    public static Response<?> error(String message){
        return new Response<>(ResponseCode.BUSINESS_ERROR.getCode(), String.format(ResponseCode.BUSINESS_ERROR.getMessage(),message),null);
    }

}
