package com.D7.myPet.service.map;

import org.mapstruct.Mapper;

import java.util.List;

public interface GenericMapper <D,E>{

    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(List<D> DtoList);

    List<D> toDto(List<E> EntityList);
}
