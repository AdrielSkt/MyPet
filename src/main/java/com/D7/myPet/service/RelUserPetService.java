package com.D7.myPet.service;

import com.D7.myPet.repository.RelUserPetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RelUserPetService {

    private final RelUserPetRepository relUserPetRepository;



}
