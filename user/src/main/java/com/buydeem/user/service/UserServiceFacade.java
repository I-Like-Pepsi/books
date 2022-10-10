package com.buydeem.user.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.buydeem.common.dto.rep.UserRep;
import com.buydeem.common.dto.req.UserQueryReq;
import com.buydeem.common.dto.req.UserReq;
import com.buydeem.common.error.BaseException;
import com.buydeem.user.convert.UserMapper;
import com.buydeem.user.entity.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class UserServiceFacade {
    @Resource
    private UserService userService;

    /**
     * 创建用户
     * @param req
     */
    @Transactional(rollbackFor = Exception.class)
    public void createUser(UserReq req){
        Wrapper<UserEntity> queryWrapper = Wrappers.lambdaQuery(UserEntity.class)
                .eq(UserEntity::getEmail, req.getEmail());
        UserEntity dbUser = userService.getOne(queryWrapper);
        if (dbUser != null){
            throw new BaseException("用户已存在");
        }
        UserEntity userEntity = UserMapper.INSTANCE.userToUserEntity(req);
        userService.save(userEntity);
    }

    public UserRep getUser(UserQueryReq req){
        LambdaQueryWrapper<UserEntity> queryWrapper = Wrappers.lambdaQuery(UserEntity.class);
        if (req.getId() != null){
            queryWrapper.eq(UserEntity::getId,req.getId());
        }else if (StringUtils.hasText(req.getEmail())){
            queryWrapper.eq(UserEntity::getEmail,req.getEmail());
        }else {
            throw new BaseException("查询条件不能为空");
        }
        UserEntity find = userService.getOne(queryWrapper);
        if (find == null){
            throw new BaseException("找不到指定用户");
        }
        return UserMapper.INSTANCE.userToUserRep(find);
    }
}
