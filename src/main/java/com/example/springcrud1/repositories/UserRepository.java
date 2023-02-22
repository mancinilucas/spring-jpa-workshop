package com.example.springcrud1.repositories;

import com.example.springcrud1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
