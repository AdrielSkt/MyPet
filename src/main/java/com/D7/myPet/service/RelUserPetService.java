package com.D7.myPet.service;

import com.D7.myPet.domain.entity.RelUserPet;
import com.D7.myPet.repository.RelUserPetRepository;
import com.D7.myPet.service.exeption.BusinessExeption;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RelUserPetService {

    private final RelUserPetRepository relUserPetRepository;

    public void createRelation(long userId, long petId){
        RelUserPet relUserPet = new RelUserPet(userId, petId);
        try {
            relUserPetRepository.save(relUserPet);
        }catch (Exception e ){
            throw new BusinessExeption("Error failed to save relationship",e);
        }

    }

    public void deleteRelation(long userId, long petId){
        RelUserPet relUserPet = new RelUserPet(userId, petId);
        try {
            relUserPetRepository.delete(relUserPet);
        }catch (Exception e ){
            throw new BusinessExeption("Error failed to save relationship",e);
        }

    }

    public void deleteRelationByPetId(long petId){
        try {
            List<RelUserPet> relUserPets = relUserPetRepository.findByPetId(petId);
            for(RelUserPet rel : relUserPets){
                relUserPetRepository.delete(rel);
            }
        }catch (Exception e ){
            throw new BusinessExeption("Error failed to delete relationship",e);
        }
    }

    public void deleteRelationByUserId(long userId){
        try {
            List<RelUserPet> relUserPets = relUserPetRepository.findByUserId(userId);
            for(RelUserPet rel : relUserPets){
                relUserPetRepository.delete(rel);
            }
        }catch (Exception e ){
            throw new BusinessExeption("Error failed to delete relationship",e);
        }
    }

}
