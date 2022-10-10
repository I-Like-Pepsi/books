package com.buydeem.common.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserQueryReq {
    /**
     * 用户ID
     */
    private Integer id;
    /**
     * 用户邮箱
     */
    private String email;
}
