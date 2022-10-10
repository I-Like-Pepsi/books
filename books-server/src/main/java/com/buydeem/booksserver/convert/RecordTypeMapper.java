package com.buydeem.booksserver.convert;

import com.buydeem.booksserver.entity.RecordTypeEntity;
import com.buydeem.common.dto.rep.RecordTypeRep;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecordTypeMapper {

    RecordTypeMapper INSTANCE = Mappers.getMapper(RecordTypeMapper.class);

    RecordTypeRep recordTypeToRecordTypeRep(RecordTypeEntity entity);

}
