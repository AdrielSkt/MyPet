package com.D7.myPet.service.dto;
import com.D7.myPet.domain.enums.Animal;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PetDto {
    private Long id;
    private String name;
    private Animal tipeOfAnimal;
    private String raceOfAnimal;
    private List<Long> ownersId;

}
