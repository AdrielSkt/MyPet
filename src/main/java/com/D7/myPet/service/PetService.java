package com.D7.myPet.service;

import com.D7.myPet.domain.entity.Pet;
import com.D7.myPet.repository.PetRepository;
import com.D7.myPet.service.dto.PetDto;
import com.D7.myPet.service.exeption.BusinessExeption;
import com.D7.myPet.service.map.PetMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class PetService {


    private final PetRepository petRepository;

    private final UserService userService;

    private final PetMapper petMapper;



    public List<PetDto> findAll(){
        return petMapper.toDto(petRepository.findAll());
    }

    public PetDto findByID(Long id){
        Optional<Pet> pet = petRepository.findById(id);
        if(pet.isPresent()){
            return petMapper.toDto(pet.get());
            }
        throw new BusinessExeption("The pet does not exists in the database");
    }


    public PetDto save(PetDto pet){
        return petMapper.toDto(petRepository.save(petMapper.toEntity(pet)));
    }
    public PetDto update(PetDto pet){
        petRepository.findById(pet.getId()).orElseThrow(()-> new BusinessExeption("The pet does not exists in the database"));

        return petMapper.toDto(petRepository.save(petMapper.toEntity(pet)));
    }

    public void delete(Long id){
        petRepository.findById(id).orElseThrow(()-> new BusinessExeption("The pet does not exists in the database"));
        userService.deleteUserPetRelationsByPetId(id);
        petRepository.deleteById(id);
    }
}
