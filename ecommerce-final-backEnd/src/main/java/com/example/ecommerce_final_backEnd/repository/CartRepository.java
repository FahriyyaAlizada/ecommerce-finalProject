package com.example.ecommerce_final_backEnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce_final_backEnd.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{
	List<Cart> findAllByUserId(Integer id);
}
