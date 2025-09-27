package com.example.ecommerce_final_backEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce_final_backEnd.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
