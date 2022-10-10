package com.buydeem.common.constant;

import lombok.Getter;

@Getter
public enum ResponseCode {
    /**
     * 请求成功
     */
    OK("2000", "请求成功"),
    /**
     * 业务异常
     */
    BUSINESS_ERROR("3000","业务异常:{%s}"),
    /**
     * 未知的服务端异常
     */
    ERROR("5000", "未知的服务端异常");


    ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;
}
