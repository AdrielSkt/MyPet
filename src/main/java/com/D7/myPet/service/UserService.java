package com.D7.myPet.service;

import com.D7.myPet.domain.entity.User;
import com.D7.myPet.repository.UserRepository;
import com.D7.myPet.service.dto.PetDto;
import com.D7.myPet.service.dto.UserDto;
import com.D7.myPet.service.exeption.BusinessExeption;
import com.D7.myPet.service.map.UserMapper;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  RelUserPetService relUserPetService;

    @Autowired
    private UserMapper userMapper;


    public List<UserDto> findAll(){
        return userMapper.toDto(userRepository.findAll());
    }

    public UserDto findById(Long id){
        Optional<User> user = userRepository.findById(id);
            return userMapper.toDto(user.orElseThrow(()->new BusinessExeption("The user does not exists in the database")));
    }

    public UserDto save(UserDto user){
//colocar regra para a lista de pet ficar nula e o msm no pet service
        if(userRepository.existsByEmail(user.getEmail())){
            throw new BusinessExeption("email is already linked to a user");
        }
        return userMapper.toDto(userRepository.save(userMapper.toEntity(user)));
    }

    public UserDto update(UserDto user){
        userRepository.findById(user.getId()).orElseThrow(() -> new BusinessExeption("The user does not exist in the database"));

            return userMapper.toDto(userRepository.save(userMapper.toEntity(user)));

    }

    public void delete(Long id){
        UserDto userDto = userMapper.toDto(userRepository.findById(id).orElseThrow(() -> new BusinessExeption("The user does not exist in the database")));
        try {
            for(PetDto pet : userDto.getPets()){
                relUserPetService.deleteRelation(id,pet.getId());
            }
            userRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            userRepository.deleteById(id);
        }


        //colocar regra de pra caso o pet esteja vinculado a apenas este usuario ele e o relacionamento serao apagados tambem/ o hibernate faz isso automaticamente
    }

}
