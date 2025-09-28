package com.example.ecommerce_final_backEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce_final_backEnd.exception.OurRuntimeException;
import com.example.ecommerce_final_backEnd.requestDto.OrderRequestDto;
import com.example.ecommerce_final_backEnd.response.OrderResponseDto;
import com.example.ecommerce_final_backEnd.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/orders")
@CrossOrigin(origins = "*")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping(path = "/add")
	public ResponseEntity<String> order(@Valid @RequestBody OrderRequestDto dto, BindingResult br){
		if (br.hasErrors()) {
			throw new OurRuntimeException(br, "Information has errors...");
		}
		orderService.order(dto);
		return ResponseEntity.ok("The order was created successfully.");
	}
	
	@GetMapping(path = "/getById/{id}")
	public OrderResponseDto getOrder(@PathVariable Integer id) {
		return orderService.get(id);
	}
}
