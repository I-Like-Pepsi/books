package com.buydeem.common.dto.req;

import com.buydeem.common.dto.PageReq;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class BooksRecordListQueryReq extends PageReq {
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    /**
     * 是否是收入
     */
    private Boolean incomeFlag;
    /**
     * 账目类型
     */
    private Integer recordType;

}
