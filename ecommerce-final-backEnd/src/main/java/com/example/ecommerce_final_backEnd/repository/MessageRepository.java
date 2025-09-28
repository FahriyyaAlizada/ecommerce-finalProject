package com.example.ecommerce_final_backEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce_final_backEnd.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{

}
