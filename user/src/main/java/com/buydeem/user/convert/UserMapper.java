package com.buydeem.user.convert;

import com.buydeem.common.dto.rep.UserRep;
import com.buydeem.common.dto.req.UserReq;
import com.buydeem.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity userToUserEntity(UserReq req);

    UserRep userToUserRep(UserEntity entity);
}
