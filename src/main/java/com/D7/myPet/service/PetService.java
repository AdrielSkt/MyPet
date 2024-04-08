package com.D7.myPet.service;

import com.D7.myPet.domain.entity.Pet;
import com.D7.myPet.repository.PetRepository;
import com.D7.myPet.service.dto.PetDto;
import com.D7.myPet.service.dto.UserDto;
import com.D7.myPet.service.exeption.BusinessExeption;
import com.D7.myPet.service.map.PetMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class PetService {


    private final PetRepository petRepository;

    private final UserService userService;

    private final RelUserPetService relUserPetService;

    private final PetMapper petMapper;



    public List<PetDto> findAll(){
        return petMapper.toDto(petRepository.findAll());
    }

    public PetDto findByID(Long id){
        Optional<Pet> pet = petRepository.findById(id);
            return petMapper.toDto(pet.orElseThrow(()-> new BusinessExeption("The pet does not exists in the database")));

    }


    public PetDto save(PetDto pet){
        if(pet.getOwnersId() == null || pet.getOwnersId().isEmpty()){
            throw new BusinessExeption("OwnerID is null");
        }

        PetDto petSaved = petMapper.toDto(petRepository.save(petMapper.toEntity(pet)));

        for(Long userId :pet.getOwnersId()){
            relUserPetService.createRelation(userId,petSaved.getId());
        }
        return petSaved;
    }
    public PetDto update(PetDto pet){
        petRepository.findById(pet.getId()).orElseThrow(()-> new BusinessExeption("The pet does not exists in the database"));

        return petMapper.toDto(petRepository.save(petMapper.toEntity(pet)));
    }

    public void delete(Long id){
        petMapper.toDto(petRepository.findById(id).orElseThrow(()-> new BusinessExeption("The pet does not exists in the database")));
        relUserPetService.deleteRelationByPetId(id);
        petRepository.deleteById(id);
    }
}
