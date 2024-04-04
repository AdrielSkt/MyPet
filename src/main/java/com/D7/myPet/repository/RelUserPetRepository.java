package com.D7.myPet.repository;

import com.D7.myPet.domain.entity.RelUserPet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RelUserPetRepository extends JpaRepository<RelUserPet,RelUserPet> {


    @Query("select rel " +
            "from RelUserPet rel " +
            "where rel.id.petId = :petId")
    public List<RelUserPet> findByPetId(@Param("petId") long petId);


    @Query("select rel " +
            "from RelUserPet rel " +
            "where rel.id.userId = :userId")
    public List<RelUserPet> findByUserId(@Param("userId") long userId);
}



