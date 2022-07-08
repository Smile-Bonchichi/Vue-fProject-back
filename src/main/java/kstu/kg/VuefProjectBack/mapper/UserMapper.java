package kstu.kg.VuefProjectBack.mapper;

import kstu.kg.VuefProjectBack.dto.request.UserAuthDtoRequest;
import kstu.kg.VuefProjectBack.entity.User;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUserEntity(UserAuthDtoRequest userAuthDtoRequest);
}
