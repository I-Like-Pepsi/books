package com.buydeem.booksserver.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buydeem.booksserver.convert.BooksRecordMapper;
import com.buydeem.booksserver.convert.RecordTypeMapper;
import com.buydeem.booksserver.entity.BooksRecordEntity;
import com.buydeem.booksserver.mapper.BooksRecordEntityMapper;
import com.buydeem.booksserver.service.BooksRecordService;
import com.buydeem.common.dto.PageRep;
import com.buydeem.common.dto.rep.BooksRecordRep;
import com.buydeem.common.dto.rep.RecordTypeRep;
import com.buydeem.common.dto.req.BooksRecordListQueryReq;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BooksRecordServiceImpl extends ServiceImpl<BooksRecordEntityMapper, BooksRecordEntity> implements BooksRecordService {

    @Resource
    private BooksRecordEntityMapper booksRecordEntityMapper;

    @Override
    public PageRep<BooksRecordRep> queryListForPage(BooksRecordListQueryReq req) {
        IPage<BooksRecordEntity> page = new Page<>(req.getPageNum(),req.getPageSize());
        IPage<BooksRecordEntity> pageResult = booksRecordEntityMapper.queryListForPage(page, req);
        List<BooksRecordRep> records = new ArrayList<>();
        for (BooksRecordEntity item : pageResult.getRecords()) {
            BooksRecordRep booksRecordRep = BooksRecordMapper.INSTANCE.booksRecordToBooksRecordRep(item);
            RecordTypeRep recordTypeRep = RecordTypeMapper.INSTANCE.recordTypeToRecordTypeRep(item.getRecordType());
            booksRecordRep.setRecordType(recordTypeRep);
            records.add(booksRecordRep);
        }
        return PageRep.create(page,records);
    }
}
