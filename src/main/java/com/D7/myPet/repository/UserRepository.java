package com.D7.myPet.repository;

import com.D7.myPet.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {


    public boolean existsByEmail(@Param("email") String email);
}
