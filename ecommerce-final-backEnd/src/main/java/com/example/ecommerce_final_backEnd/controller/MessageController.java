package com.example.ecommerce_final_backEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce_final_backEnd.entity.Message;
import com.example.ecommerce_final_backEnd.repository.MessageRepository;

@RestController
@RequestMapping(path = "/contact")
@CrossOrigin(origins = "*")
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;

    @PostMapping
    public String saveMessage(@RequestBody Message message) {
        messageRepository.save(message);
        return "Message saved successfully!";
    }

}
