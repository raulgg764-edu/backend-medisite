package com.medisitegg.microserviceuser.repository;

import com.medisitegg.microserviceuser.repository.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UserRepository extends CrudRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}
