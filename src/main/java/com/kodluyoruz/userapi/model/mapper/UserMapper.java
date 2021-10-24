package com.kodluyoruz.userapi.model.mapper;

import com.kodluyoruz.userapi.model.dto.UserDto;
import com.kodluyoruz.userapi.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    UserDto toUserDto(User user);
}
