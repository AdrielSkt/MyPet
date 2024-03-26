package com.D7.myPet.domain.entity;

import com.D7.myPet.domain.enums.Animal;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pet")
public class Pet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Animal tipeOfAnimal;
    private String RaceOfAnimal;

}
