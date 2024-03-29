package com.D7.myPet.service.dto;

import com.D7.myPet.domain.entity.User;
import com.D7.myPet.domain.enums.Animal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDto {
    private Long id;
    private String name;
    private Animal tipeOfAnimal;
    private String raceOfAnimal;

}
