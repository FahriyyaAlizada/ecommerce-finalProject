package com.example.ecommerce_final_backEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce_final_backEnd.requestDto.CartRequestDto;
import com.example.ecommerce_final_backEnd.response.CartResponseDto;
import com.example.ecommerce_final_backEnd.service.CartService;

@RestController
@RequestMapping(path = "/card")
@CrossOrigin(origins = "*")
public class CartController {
	@Autowired
	private CartService cartService;
 
	@PostMapping(path = "/add")
	public ResponseEntity<String> addToCart(@RequestBody CartRequestDto dto){
		cartService.addToCart(dto);
		return ResponseEntity.ok("Product added to card successfully");
	}
	
	@GetMapping(path = "/getCard") 
	public List<CartResponseDto> getCart(){
		return cartService.getCart();
	}
	
	@PutMapping(path = "/update")
	public void update(@RequestBody CartRequestDto dto) {
		cartService.update(dto);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public void deleteFromCart(@PathVariable Integer id) {
		cartService.delete(id);
	}
}
