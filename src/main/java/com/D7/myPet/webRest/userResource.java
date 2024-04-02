package com.D7.myPet.webRest;

import com.D7.myPet.domain.entity.User;
import com.D7.myPet.service.UserService;
import com.D7.myPet.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class userResource {

    @Autowired
    UserService userService;
    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        List<UserDto> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> findByID(@PathVariable Long id){
        UserDto user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto user){
        UserDto userSaved = userService.save(user);
        return ResponseEntity.created(URI.create("api/user"+userSaved.getId())).body(userSaved);
    }

    @PutMapping
    public ResponseEntity<UserDto> update(@RequestBody UserDto user){
        UserDto userUpdated = userService.update(user);
        return ResponseEntity.created(URI.create("api/user"+userUpdated.getId())).body(userUpdated);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
