package com.D7.myPet.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String phone;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_user_pet", joinColumns = {
            @JoinColumn(name="user_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "pet_id")
    })
    private List<Pet> pets;
}
