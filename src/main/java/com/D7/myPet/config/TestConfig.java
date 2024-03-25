package com.D7.myPet.config;

import com.D7.myPet.domain.entity.Pet;
import com.D7.myPet.domain.entity.User;
import com.D7.myPet.domain.enums.Animal;
import com.D7.myPet.repository.PetRepository;
import com.D7.myPet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PetRepository petRepository;

    @Override
    public void run(String... args) throws Exception {

        User user = new User(null, "Adriel", "adr@gmail.com", "61996475173", new ArrayList<>());
        User user2 = new User(null, "Marcus", "marc@gmail.com", "61996475173", new ArrayList<>());

// Criar pets
        Pet pet1 = new Pet(null, "Kimbu", Animal.PEIXE, "Nemo",new ArrayList<>());
        Pet pet2 = new Pet(null, "Linux", Animal.CACHORRO, "Pintcher",new ArrayList<>());

// Adicionar usuários como proprietários dos pets
        pet1.getOwners().add(user);
        pet1.getOwners().add(user2);
        pet2.getOwners().add(user2);

// Adicionar pets aos usuários
        user.getPets().add(pet1);
        user2.getPets().add(pet1);
        user2.getPets().add(pet2);

// Salvando pets e usuários
        List<Pet> savedPets = petRepository.saveAll(Arrays.asList(pet1, pet2));
        List<User> savedUsers = userRepository.saveAll(Arrays.asList(user, user2));
    }
}
