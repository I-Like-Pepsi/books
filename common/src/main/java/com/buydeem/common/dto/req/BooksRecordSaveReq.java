package com.buydeem.common.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;

@Data
public class BooksRecordSaveReq {
    public interface Create{}
    public interface Update{}
    /**
     * 记账记录ID
     */
    @Null(message = "账目ID必须为空",groups = Create.class)
    @NotNull(message = "账目ID不能为空",groups = Update.class)
    private Integer id;
    /**
     * 创建用户ID
     */
    @NotNull(message = "创建用户ID不能为空",groups = Create.class)
    @Null(message = "创建用户ID必须为空",groups = Update.class)
    private Integer userId;
    /**
     * 记账金额
     */
    @NotNull(message = "记账金额不能为空")
    @DecimalMin(value = "0.01",message = "金额最小值为0.01")
    @DecimalMax(value = "999999.99",message = "金额最大值为999999.99")
    private BigDecimal amount;
    /**
     * 是否是收入
     */
    @NotNull(message = "是否是收入不能为空")
    private Boolean incomeFlag;
    /**
     * 备注信息
     */
    @Length(max = 250,message = "备注信息最大值不能超过250")
    private String remark;
    /**
     * 账目记录类型
     */
    @NotNull(message = "账目记录类型不能为空")
    private Integer recordTypeId;
}
