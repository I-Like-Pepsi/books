package com.buydeem.booksserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.buydeem.booksserver.entity.BooksRecordEntity;
import com.buydeem.common.dto.req.BooksRecordListQueryReq;
import org.apache.ibatis.annotations.Param;

public interface BooksRecordEntityMapper extends BaseMapper<BooksRecordEntity> {

    /**
     * 分页查询记录
     * @param page
     * @param req
     * @return
     */
    IPage<BooksRecordEntity> queryListForPage(IPage<?> page, @Param("query") BooksRecordListQueryReq req);

}
