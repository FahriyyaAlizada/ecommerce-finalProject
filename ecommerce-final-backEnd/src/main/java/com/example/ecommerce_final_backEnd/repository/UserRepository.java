package com.example.ecommerce_final_backEnd.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce_final_backEnd.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUsername(String username);
	
	User getUserByUsername(String username);
}
