package com.buydeem.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buydeem.user.entity.UserEntity;
import com.buydeem.user.mapper.UserEntityMapper;
import com.buydeem.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserEntityMapper, UserEntity> implements UserService {
}
