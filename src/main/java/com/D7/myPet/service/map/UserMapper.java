package com.D7.myPet.service.map;

import com.D7.myPet.domain.entity.User;
import com.D7.myPet.service.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PetMapper.class})
public interface UserMapper extends GenericMapper<UserDto, User> {
}
