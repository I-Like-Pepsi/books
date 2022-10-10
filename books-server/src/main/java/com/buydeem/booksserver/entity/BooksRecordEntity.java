package com.buydeem.booksserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.buydeem.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 记账记录表
 */
@TableName("t_books_record")
@Data
@EqualsAndHashCode(callSuper = true)
public class BooksRecordEntity extends BaseEntity {
    /**
     * 创建用户ID
     */
    private Integer userId;
    /**
     * 记账金额
     */
    private BigDecimal amount;
    /**
     * 是否是收入
     */
    private Boolean incomeFlag;
    /**
     * 备注信息
     */
    private String remark;
    /**
     * 账目记录类型
     */
    private Integer recordTypeId;
    /**
     * 是否删除
     */
    private Boolean deleteFlag;

    @TableField(exist = false)
    private RecordTypeEntity recordType;
}
