package com.buydeem.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.buydeem.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_user")
public class UserEntity extends BaseEntity {
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickName;
}
