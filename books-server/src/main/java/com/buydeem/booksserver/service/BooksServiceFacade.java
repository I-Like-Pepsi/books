package com.buydeem.booksserver.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.buydeem.booksserver.api.UserService;
import com.buydeem.booksserver.convert.BooksRecordMapper;
import com.buydeem.booksserver.convert.RecordTypeMapper;
import com.buydeem.booksserver.entity.BooksRecordEntity;
import com.buydeem.booksserver.entity.RecordTypeEntity;
import com.buydeem.common.dto.PageRep;
import com.buydeem.common.dto.rep.BooksRecordRep;
import com.buydeem.common.dto.rep.RecordTypeRep;
import com.buydeem.common.dto.rep.UserRep;
import com.buydeem.common.dto.req.BooksRecordListQueryReq;
import com.buydeem.common.dto.req.BooksRecordSaveReq;
import com.buydeem.common.dto.req.UserQueryReq;
import com.buydeem.common.error.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Slf4j
public class BooksServiceFacade {

    @Resource
    private UserService userService;
    @Resource
    private RecordTypeService recordTypeService;
    @Resource
    private BooksRecordService booksRecordService;

    /**
     * 保存记账信息
     *
     * @param req
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveBooksRecord(BooksRecordSaveReq req) {
        if (req.getId() == null) {
            //检查用户是否存在
            UserRep user = userService.getUser(new UserQueryReq(req.getUserId(), null));
            if (user == null) {
                throw new BaseException("用户不存在!");
            }
            //检查账目类型
            RecordTypeEntity recordType = recordTypeService.getById(req.getRecordTypeId());
            if (recordType == null) {
                throw new BaseException("账目类型不存在!");
            }
            BooksRecordEntity booksRecord = BooksRecordMapper.INSTANCE.booksRecordToBooksRecordEntity(req);
            booksRecordService.save(booksRecord);
        } else {
            BooksRecordEntity booksRecord = booksRecordService.getById(req.getId());
            if (booksRecord == null) {
                throw new BaseException("找不到账目记录!");
            }
            booksRecord.setAmount(req.getAmount());
            booksRecord.setIncomeFlag(req.getIncomeFlag());
            booksRecord.setRemark(req.getRemark());
            booksRecord.setRecordTypeId(req.getRecordTypeId());

            LambdaUpdateWrapper<BooksRecordEntity> wrapper = Wrappers.lambdaUpdate(BooksRecordEntity.class).eq(BooksRecordEntity::getId, req.getId())
                    .eq(BooksRecordEntity::getDeleteFlag, false)
                    .eq(BooksRecordEntity::getUpdateTime, booksRecord.getUpdateTime());
            booksRecord.setUpdateTime(null);
            boolean success = booksRecordService.update(booksRecord, wrapper);
            if (!success) {
                throw new BaseException("更新失败!");
            }
        }
    }

    /**
     * 获取详情
     * @param id
     * @return
     */
    public BooksRecordRep getDetail(Integer id){
        LambdaQueryWrapper<BooksRecordEntity> queryWrapper = Wrappers.lambdaQuery(BooksRecordEntity.class)
                .eq(BooksRecordEntity::getId, id)
                .eq(BooksRecordEntity::getDeleteFlag, false);
        BooksRecordEntity booksRecord = booksRecordService.getOne(queryWrapper);
        if (booksRecord == null){
            return null;
        }
        BooksRecordRep booksRecordRep = BooksRecordMapper.INSTANCE.booksRecordToBooksRecordRep(booksRecord);
        //获取记账类型
        RecordTypeEntity recordType = recordTypeService.getById(booksRecord.getRecordTypeId());
        if (recordType != null){
            RecordTypeRep recordTypeRep = RecordTypeMapper.INSTANCE.recordTypeToRecordTypeRep(recordType);
            booksRecordRep.setRecordType(recordTypeRep);
        }
        return booksRecordRep;
    }



}
