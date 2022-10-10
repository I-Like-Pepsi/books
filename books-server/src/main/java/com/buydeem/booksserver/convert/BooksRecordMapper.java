package com.buydeem.booksserver.convert;

import com.buydeem.booksserver.entity.BooksRecordEntity;
import com.buydeem.common.dto.rep.BooksRecordRep;
import com.buydeem.common.dto.req.BooksRecordSaveReq;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BooksRecordMapper {

    BooksRecordMapper INSTANCE = Mappers.getMapper(BooksRecordMapper.class);

    BooksRecordEntity booksRecordToBooksRecordEntity(BooksRecordSaveReq req);

    BooksRecordRep booksRecordToBooksRecordRep(BooksRecordEntity entity);
}
