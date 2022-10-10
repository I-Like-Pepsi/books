package com.buydeem.booksserver.api;

import com.buydeem.booksserver.config.feign.UserServiceConfig;
import com.buydeem.common.dto.rep.UserRep;
import com.buydeem.common.dto.req.UserQueryReq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user-server",configuration = UserServiceConfig.class)
public interface UserService {

    @GetMapping("user")
    UserRep getUser(@SpringQueryMap UserQueryReq req);

}
