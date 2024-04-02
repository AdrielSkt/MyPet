package com.D7.myPet.config;

import com.D7.myPet.domain.entity.Pass;
import com.D7.myPet.domain.entity.Pet;
import com.D7.myPet.domain.entity.RelUserPet;
import com.D7.myPet.domain.entity.User;
import com.D7.myPet.domain.enums.Animal;
import com.D7.myPet.repository.PassRepository;
import com.D7.myPet.repository.PetRepository;
import com.D7.myPet.repository.RelUserPetRepository;
import com.D7.myPet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.*;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private RelUserPetRepository relUserPetRepository;

    @Autowired
    private PassRepository passRepository;

    @Override
    public void run(String... args) throws Exception {

        User user = new User(null, "Adriel", "adr@gmail.com", "61996475173", null);
        User user2 = new User(null, "Marcus", "marc@gmail.com", "61996475173", null);

// Criar pets
        Pet pet1 = new Pet(null, "Kimbu", Animal.PEIXE, "Nemo", null);
        Pet pet2 = new Pet(null, "Linux", Animal.CACHORRO, "Pintcher", null);
        List<Pet> savedPets = petRepository.saveAll(Arrays.asList(pet1, pet2));

// Salvando usuários
        List<User> savedUsers = userRepository.saveAll(Arrays.asList(user, user2));


        RelUserPet rel1 = new RelUserPet(1L,2L);
        RelUserPet rel2 = new RelUserPet(1L,1L);
        RelUserPet rel3 = new RelUserPet(2L,2L);

        relUserPetRepository.saveAll(Arrays.asList(rel1,rel2,rel3));



// Salvando pass
        Pass pass = new Pass(null,savedUsers.get(1).getId(), Base64.getDecoder().decode("VGhpcyBpcyBhIHN0cmluZw=="));


        passRepository.saveAll(List.of(pass));
    }
}
