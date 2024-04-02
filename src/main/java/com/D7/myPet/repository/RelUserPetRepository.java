package com.D7.myPet.repository;

import com.D7.myPet.domain.entity.RelUserPet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelUserPetRepository extends JpaRepository<RelUserPet,Long> {
}
