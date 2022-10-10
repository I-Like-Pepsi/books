package com.buydeem.booksserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.buydeem.booksserver.entity.BooksRecordEntity;
import com.buydeem.common.dto.PageRep;
import com.buydeem.common.dto.rep.BooksRecordRep;
import com.buydeem.common.dto.req.BooksRecordListQueryReq;

public interface BooksRecordService extends IService<BooksRecordEntity> {

    PageRep<BooksRecordRep> queryListForPage(BooksRecordListQueryReq req);
}
