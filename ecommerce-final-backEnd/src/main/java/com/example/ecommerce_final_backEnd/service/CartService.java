package com.example.ecommerce_final_backEnd.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.ecommerce_final_backEnd.entity.Cart;
import com.example.ecommerce_final_backEnd.entity.Product;
import com.example.ecommerce_final_backEnd.entity.User;
import com.example.ecommerce_final_backEnd.exception.OurRuntimeException;
import com.example.ecommerce_final_backEnd.repository.CartRepository;
import com.example.ecommerce_final_backEnd.repository.ProductRepository;
import com.example.ecommerce_final_backEnd.repository.UserRepository;
import com.example.ecommerce_final_backEnd.requestDto.CartRequestDto;
import com.example.ecommerce_final_backEnd.response.CartResponseDto;

@Service
public class CartService {
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;


	public void addToCart(CartRequestDto dto) {
		Product product = productRepository.findById(dto.getProductId())
				.orElseThrow(() -> new OurRuntimeException(null, "product cannot be found"));
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.getUserByUsername(username);
		Integer id = user.getId();
				
				Cart cart = new Cart();
				cart.setProduct(product);
				cart.setQuantity(1);
				Double subTotal = product.getPrice() * cart.getQuantity();
				cart.setSubTotal(subTotal);
				cart.setUserId(id);
				cartRepository.save(cart);
		
	}


	public List<CartResponseDto> getCart() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.getUserByUsername(username);
		Integer id = user.getId();
		
		List<Cart> carts = cartRepository.findAllByUserId(id);
		return carts.stream().map(cart -> {
			CartResponseDto response = new CartResponseDto();
			response.setId(cart.getId());
			response.setProduct(cart.getProduct());
			response.setQuantity(cart.getQuantity());
			response.setUserId(cart.getUserId());
			response.setSubTotal(cart.getSubTotal());
			response.setUserId(id);
			return response;
		})
				.collect(Collectors.toList());
	}


	public void update(CartRequestDto dto) {
		Cart cart = cartRepository.findById(dto.getId())
				.orElseThrow(() -> new OurRuntimeException(null, "card cannot be found"));
				
				Integer quantity = (dto.getQuantity() == null || dto.getQuantity() <= 0)? 1 : dto.getQuantity();
				
				cart.setQuantity(quantity);
				
				Double subTotal = cart.getProduct().getPrice() * quantity;
				
				cart.setSubTotal(subTotal);
				cartRepository.save(cart);
		
	}


	public void delete(Integer id) {
		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id is required");
		}
		
		if (cartRepository.findById(id).isPresent()) {
			cartRepository.deleteById(id);
		}else {
			throw new OurRuntimeException(null, "id cannot be found");
		}
		
	}
}
