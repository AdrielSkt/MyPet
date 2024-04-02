package com.D7.myPet.domain.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="rel_user_pet")
@NoArgsConstructor
public class RelUserPet {

@EmbeddedId
private Ids id = new Ids();

public RelUserPet(Long userId, Long petId){
    getId().setUserId(userId);
    getId().setPetId(petId);
}

}
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Ids {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "pet_id")
    private Long petId;
}

