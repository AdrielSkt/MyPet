package com.D7.myPet.webRest;


import com.D7.myPet.domain.entity.Pet;
import com.D7.myPet.service.PetService;
import com.D7.myPet.service.dto.PetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetResources {

    @Autowired
    PetService petService;


    @GetMapping
    public ResponseEntity<List<PetDto>> findAll(){
        List<PetDto> pets = petService.findAll();
        return ResponseEntity.ok().body(pets);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PetDto> findById(@PathVariable Long id){
        PetDto pet = petService.findByID(id);
        return ResponseEntity.ok().body(pet);
    }

    @PostMapping
    public ResponseEntity<PetDto> save(@RequestBody PetDto pet){
        PetDto petSaved = petService.save(pet);
        return ResponseEntity.created(URI.create("api/pet"+petSaved.getId())).body(petSaved);
    }

    @PutMapping
    public ResponseEntity<PetDto> update(@RequestBody PetDto pet){
        PetDto petSaved = petService.update(pet);
        return ResponseEntity.created(URI.create("api/pet"+petSaved.getId())).body(petSaved);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        petService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
