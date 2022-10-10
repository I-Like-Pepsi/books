package com.buydeem.user.controller;

import com.buydeem.common.dto.Response;
import com.buydeem.common.dto.rep.UserRep;
import com.buydeem.common.dto.req.UserQueryReq;
import com.buydeem.common.dto.req.UserReq;
import com.buydeem.user.service.UserServiceFacade;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserServiceFacade userServiceFacade;

    /**
     * 创建用户
     *
     * @param req
     * @return
     */
    @PostMapping
    public Response<?> createUser(@Validated @RequestBody UserReq req) {
        userServiceFacade.createUser(req);
        return Response.ok(null);
    }

    /**
     * 查询用户
     *
     * @param req
     * @return
     */
    @GetMapping
    public Response<UserRep> getUser(UserQueryReq req) {
        UserRep rep = userServiceFacade.getUser(req);
        return Response.ok(rep);
    }
}
