package com.buydeem.booksserver.controller;

import com.buydeem.booksserver.service.BooksRecordService;
import com.buydeem.booksserver.service.BooksServiceFacade;
import com.buydeem.common.dto.PageRep;
import com.buydeem.common.dto.Response;
import com.buydeem.common.dto.rep.BooksRecordRep;
import com.buydeem.common.dto.req.BooksRecordListQueryReq;
import com.buydeem.common.dto.req.BooksRecordSaveReq;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("books")
public class BooksController {

    @Resource
    private BooksServiceFacade booksServiceFacade;
    @Resource
    private BooksRecordService booksRecordService;

    /**
     * 添加记账信息
     * @param req
     * @return
     */
    @PostMapping
    public Response<?> addRecord(@Validated(value = BooksRecordSaveReq.Create.class) @RequestBody BooksRecordSaveReq req){
        booksServiceFacade.saveBooksRecord(req);
        return Response.ok(null);
    }

    /**
     * 修改记账信息
     * @param req
     * @return
     */
    @PutMapping
    public Response<?> updateRecord(@Validated(value = BooksRecordSaveReq.Update.class) @RequestBody BooksRecordSaveReq req){
        booksServiceFacade.saveBooksRecord(req);
        return Response.ok(null);
    }

    /**
     * 获取详情
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Response<BooksRecordRep> getById(@PathVariable Integer id){
        BooksRecordRep detail = booksServiceFacade.getDetail(id);
        return Response.ok(detail);
    }

    /**
     * 列表查询
     * @param req
     * @return
     */
    @GetMapping("list")
    public Response<PageRep<BooksRecordRep>> queryList(BooksRecordListQueryReq req){
        PageRep<BooksRecordRep> page = booksRecordService.queryListForPage(req);
        return Response.ok(page);
    }

}
