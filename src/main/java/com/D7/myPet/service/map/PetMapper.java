package com.D7.myPet.service.map;

import com.D7.myPet.domain.entity.Pet;
import com.D7.myPet.service.dto.PetDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface PetMapper extends GenericMapper<PetDto, Pet> {
}
