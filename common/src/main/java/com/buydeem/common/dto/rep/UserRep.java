package com.buydeem.common.dto.rep;

import lombok.Data;

@Data
public class UserRep {
    /**
     * 用户ID
     */
    private Integer id;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 昵称
     */
    private String nickName;
}
