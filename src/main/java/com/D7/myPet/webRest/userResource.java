package com.D7.myPet.webRest;

import com.D7.myPet.domain.entity.Pet;
import com.D7.myPet.domain.entity.User;
import com.D7.myPet.domain.enums.Animal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class userResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet(1L,"Kimbu", Animal.PEIXE, "Nemo"));
        User user = new User(1L, "Adriel","adr@gmail.com","61996475173",pets);

        return ResponseEntity.ok().body(user);
    }
}
