package com.D7.myPet.domain.entity;

import com.D7.myPet.domain.enums.Animal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="pet")
public class Pet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer tipeOfAnimal;
    private String raceOfAnimal;

    @JsonIgnore
    @ManyToMany(mappedBy = "pets", fetch = FetchType.LAZY)
    private List<User> owners;


    public Pet(Long id, String name, Animal tipeOfAnimal, String raceOfAnimal, List<User> owners){
        this.id = id;
        this.name = name;
        this.setTipeOfAnimal(tipeOfAnimal);
        this.raceOfAnimal = raceOfAnimal;
        this.owners = owners;
    }
    public Animal getTipeOfAnimal() {
        return Animal.valueOff(tipeOfAnimal);
    }

    public void setTipeOfAnimal(Animal tipeOfAnimal) {
        if(tipeOfAnimal != null){
            this.tipeOfAnimal = tipeOfAnimal.getCode();
        }
    }
}
