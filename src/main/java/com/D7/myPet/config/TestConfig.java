package com.D7.myPet.config;

import com.D7.myPet.domain.entity.Pass;
import com.D7.myPet.domain.entity.Pet;
import com.D7.myPet.domain.entity.User;
import com.D7.myPet.domain.enums.Animal;
import com.D7.myPet.repository.PassRepository;
import com.D7.myPet.repository.PetRepository;
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
    private PassRepository passRepository;

    @Override
    public void run(String... args) throws Exception {

        User user = new User(null, "Adriel", "adr@gmail.com", "61996475173", new ArrayList<>());
        User user2 = new User(null, "Marcus", "marc@gmail.com", "61996475173", new ArrayList<>());

// Criar pets
        Pet pet1 = new Pet(null, "Kimbu", Animal.PEIXE, "Nemo", new ArrayList<>());
        Pet pet2 = new Pet(null, "Linux", Animal.CACHORRO, "Pintcher", new ArrayList<>());
        List<Pet> savedPets = petRepository.saveAll(Arrays.asList(pet1, pet2));
// Adicionar pets aos usuários
        user.getPets().add(pet1);
        user2.getPets().add(pet1);
        user2.getPets().add(pet2);

// Salvando usuários
        List<User> savedUsers = userRepository.saveAll(Arrays.asList(user, user2));

// atualizando pets usuários
        savedPets.get(0).setOwners(List.of(savedUsers.get(1)));
        savedPets.get(1).setOwners(List.of(savedUsers.get(0)));

        petRepository.saveAll(savedPets);


// Salvando pass
        Pass pass = new Pass(null,savedUsers.get(1).getId(), Base64.getDecoder().decode("VGhpcyBpcyBhIHN0cmluZw=="));


        passRepository.saveAll(List.of(pass));
    }
}
