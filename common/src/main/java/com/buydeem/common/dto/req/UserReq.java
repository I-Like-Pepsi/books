package com.buydeem.common.dto.req;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserReq {
    /**
     * 电子邮箱
     */
    @NotBlank(message = "电子邮箱不能为空")
    @Email(message = "电子邮箱格式不正确")
    private String email;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;
    /**
     * 昵称
     */
    @NotBlank(message = "昵称不能为空")
    private String nickName;
}
