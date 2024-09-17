package com.connectix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.connectix.entities.User;

@Repository
public interface userRepo extends JpaRepository<User, String>{

    
}
