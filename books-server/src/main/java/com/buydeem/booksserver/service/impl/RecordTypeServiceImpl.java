package com.buydeem.booksserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buydeem.booksserver.entity.RecordTypeEntity;
import com.buydeem.booksserver.mapper.RecordTypeEntityMapper;
import com.buydeem.booksserver.service.RecordTypeService;
import org.springframework.stereotype.Service;

@Service
public class RecordTypeServiceImpl extends ServiceImpl<RecordTypeEntityMapper, RecordTypeEntity> implements RecordTypeService {

}
