package com.buydeem.common.dto.rep;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BooksRecordRep {
    /**
     * 记录ID
     */
    private Integer id;

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
    private RecordTypeRep recordType;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

}
