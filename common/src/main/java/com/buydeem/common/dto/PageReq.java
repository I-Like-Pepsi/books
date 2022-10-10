package com.buydeem.common.dto;

import lombok.Data;

@Data
public class PageReq {
    /**
     * 页码
     */
    private Long pageNum = 1L;
    /**
     * 页大小
     */
    private Long pageSize = 10L;
}
