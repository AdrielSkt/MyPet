package com.D7.myPet.webRest;

import com.D7.myPet.domain.entity.User;
import com.D7.myPet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class userResource {

    @Autowired
    UserService userService;
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findByID(@PathVariable Long id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        User userSaved = userService.save(user);
        return ResponseEntity.created(URI.create("api/users"+userSaved.getId())).body(userSaved);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user){
        User userUpdated = userService.update(user);
        return ResponseEntity.created(URI.create("api/users"+userUpdated.getId())).body(userUpdated);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
