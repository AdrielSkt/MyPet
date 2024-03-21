package com.D7.myPet.domain.entity;

import com.D7.myPet.domain.enums.Animal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet implements Serializable {
    private long id;
    private String name;
    private Animal tipeOfAnimal;
    private String RaceOfAnimal;



}
