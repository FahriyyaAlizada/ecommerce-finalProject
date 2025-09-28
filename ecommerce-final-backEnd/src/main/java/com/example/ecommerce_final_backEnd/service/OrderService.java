package com.example.ecommerce_final_backEnd.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce_final_backEnd.entity.Cart;
import com.example.ecommerce_final_backEnd.entity.Order;
import com.example.ecommerce_final_backEnd.exception.OurRuntimeException;
import com.example.ecommerce_final_backEnd.repository.CartRepository;
import com.example.ecommerce_final_backEnd.repository.OrderRepository;
import com.example.ecommerce_final_backEnd.requestDto.OrderRequestDto;
import com.example.ecommerce_final_backEnd.response.OrderResponseDto;

@Service
public class OrderService {
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	public void order(OrderRequestDto dto) {
		Cart cart = cartRepository.findById(dto.getCartId())
				.orElseThrow(() -> new OurRuntimeException(null, "card cannot be found"));
				
				Order order = new Order();
				order.setFirstName(dto.getFirstName());
				order.setLastName(dto.getLastName());
				order.setCountry(dto.getCountry());
				order.setAddress(dto.getAddress());
				order.setCity(dto.getCity());
				order.setPhone(dto.getPhone());
				order.setEmail(dto.getEmail());
				order.setCartNumber(dto.getCartNumber());
				order.setExpiryMonth(dto.getExpiryMonth());
				order.setExpiryYear(dto.getExpiryYear());
				order.setZipCode(dto.getZipCode());;
				order.setCart(cart);
				orderRepository.save(order);
		
	}

	public OrderResponseDto get(Integer id) {
		if (id == null || id<=0) {
			throw new OurRuntimeException(null, "id is required");
		}
		Optional<Order> byId = orderRepository.findById(id);
		OrderResponseDto response = new OrderResponseDto();
		if (byId.isPresent()) {
			Order order = byId.get();
			response.setId(order.getId());
			response.setFirstName(order.getFirstName());
			response.setLastName(order.getLastName());
			response.setCountry(order.getCountry());
			response.setAddress(order.getAddress());
			response.setCity(order.getCity());
			response.setPhone(order.getPhone());
		}else {
			throw new OurRuntimeException(null, "id cannot be found");
		}
		return response;
	}
}
