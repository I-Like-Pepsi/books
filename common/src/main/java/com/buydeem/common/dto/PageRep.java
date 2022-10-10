package com.buydeem.common.dto;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;

@Data
public class PageRep<T> {
    /**
     * 页码
     */
    private Long pageNum;
    /**
     * 页大小
     */
    private Long pageSize;
    /**
     * 总条数
     */
    private Long total;
    /**
     * 记录列表
     */
    private List<T> rows;

    public static <T> PageRep<T> create(IPage<?> pageResult,List<T> records){
        PageRep<T> page = new PageRep<>();
        page.setPageNum(pageResult.getCurrent());
        page.setPageSize(pageResult.getSize());
        page.setTotal(pageResult.getTotal());
        page.setRows(records);
        return page;
    }
}
