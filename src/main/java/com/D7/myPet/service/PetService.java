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

    private final PetMapper petMapper;



    public List<PetDto> findAll(){
        return petMapper.toDto(petRepository.findAll());
    }

    public Pet findByID(Long id){
        Optional<Pet> pet = petRepository.findById(id);

        return pet.get();
    }


    public Pet save(Pet pet){
        return petRepository.save(pet);
    }
    public Pet update(Pet pet){
        petRepository.findById(pet.getId()).orElseThrow(()-> new BusinessExeption("The pet does not exists in the database"));

        return petRepository.save(pet);
    }

    public void delete(Long id){
        petRepository.findById(id).orElseThrow(()-> new BusinessExeption("The pet does not exists in the database"));

        petRepository.deleteById(id);
    }
}
