package com.buydeem.booksserver.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.buydeem.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 支出和收入类型
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_record_type")
public class RecordTypeEntity extends BaseEntity {
    /**
     * 类型名称
     */
    private String typeName;
    /**
     * 图标
     */
    private String icon;
    /**
     * 是否删除
     */
    private Boolean deleteFlag;
}
