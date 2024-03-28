package com.D7.myPet.service;

import com.D7.myPet.domain.entity.Pet;
import com.D7.myPet.repository.PetRepository;
import com.D7.myPet.service.exeption.BusinessExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;



    public List<Pet> findAll(){
        return petRepository.findAll();
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
