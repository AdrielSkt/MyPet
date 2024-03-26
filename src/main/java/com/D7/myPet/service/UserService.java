package com.D7.myPet.service;

import com.D7.myPet.domain.entity.User;
import com.D7.myPet.repository.UserRepository;
import com.D7.myPet.service.exeption.BusinessExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public User save(User user){

        if(userRepository.existsByEmail(user.getEmail())){
            throw new BusinessExeption("email is already linked to a user");
        }
        return userRepository.save(user);
    }

    public User update(User user){
        userRepository.findById(user.getId()).orElseThrow(() -> new BusinessExeption("The user does not exist in the database"));

            return userRepository.save(user);

    }

    public void delete(Long id){
        userRepository.findById(id).orElseThrow(() -> new BusinessExeption("The user does not exist in the database"));

        userRepository.deleteById(id);


    }
}
