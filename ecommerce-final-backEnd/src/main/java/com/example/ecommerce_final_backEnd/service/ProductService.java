package com.example.ecommerce_final_backEnd.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.ecommerce_final_backEnd.entity.Product;
import com.example.ecommerce_final_backEnd.entity.User;
import com.example.ecommerce_final_backEnd.exception.OurRuntimeException;
import com.example.ecommerce_final_backEnd.repository.ProductRepository;
import com.example.ecommerce_final_backEnd.repository.UserRepository;
import com.example.ecommerce_final_backEnd.requestDto.ProductRequestDto;
import com.example.ecommerce_final_backEnd.response.ProductListResponse;
import com.example.ecommerce_final_backEnd.response.ProductResponseDto;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UserRepository userRepository;

	public void create(ProductRequestDto d) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.getUserByUsername(username);
		Integer id = user.getId();
		
		Product product = new Product();
		product.setId(null);
		product.setBrand(d.getBrand());
		product.setModel(d.getModel());
		product.setCategory(d.getCategory());
		product.setDescription(d.getDescription());
		product.setPrice(d.getPrice());
		product.setRating(d.getRating());
		product.setImage(d.getImage());
		product.setUserId(id);
		productRepository.save(product);
	}

	public ProductListResponse getAll() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.getUserByUsername(username);
		Integer id = user.getId();
		
		List<Product> products = productRepository.findAllByUserId(id);
		ProductListResponse response = new ProductListResponse();
		response.setProducts(products);
		return response;
	}

	public ProductResponseDto get(Integer id) {
		if (id == null || id<=0) {
			throw new OurRuntimeException(null, "id is required");
		}
		Optional<Product> byId = productRepository.findById(id);
		ProductResponseDto response = new ProductResponseDto();
		if (byId.isPresent()) {
			Product product = byId.get();
			response.setId(product.getId());
			response.setBrand(product.getBrand());
			response.setModel(product.getModel());
			response.setCategory(product.getCategory());
			response.setDescription(product.getDescription());
			response.setPrice(product.getPrice());
			response.setRating(product.getRating());
			response.setImage(product.getImage());
		}else {
			throw new OurRuntimeException(null, "id cannot be found");
		}
		return response;
	}

	public void update(ProductRequestDto dto) {
		if (dto.getId() == null || dto.getId() <= 0) {
			throw new OurRuntimeException(null, "id is required");
		}
		Optional<Product> byId = productRepository.findById(dto.getId());
		if (byId.isPresent()) {
			Product product = byId.get();
			product.setId(dto.getId());
			product.setBrand(dto.getBrand());
			product.setModel(dto.getModel());
			product.setCategory(dto.getCategory());
			product.setDescription(dto.getDescription());
			product.setPrice(dto.getPrice());
			product.setRating(dto.getRating());
			product.setImage(dto.getImage());
			productRepository.save(product);
		}else {
			throw new OurRuntimeException(null, "id cannot be found");
		}
		
	}

	public void delete(Integer id) {
		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id is required");
		}
		if (productRepository.findById(id).isPresent()) {
			productRepository.deleteById(id);
		}else {
			throw new OurRuntimeException(null, "id cannot be found");
		}
	}

	public ProductListResponse getAllProduct() {
		ProductListResponse response = new ProductListResponse();
		List<Product> all = productRepository.findAll();
		response.setProducts(all);
		return response;
	}

	public List<ProductResponseDto> search(String query) {
		List<Product> products = productRepository.findAll();
		return products.stream().filter(product -> product.getBrand().toLowerCase().contains(query.toLowerCase()))
				.map(product -> {
					ProductResponseDto response = new ProductResponseDto();
					response.setId(product.getId());
					response.setBrand(product.getBrand());
					response.setModel(product.getModel());
					response.setCategory(product.getCategory());
					response.setDescription(product.getDescription());
					response.setPrice(product.getPrice());
					response.setRating(product.getRating());
					response.setImage(product.getImage());
					return response;
				})
				.collect(Collectors.toList());
	}

	public List<ProductResponseDto> sortedProduct(String sort) {
		List<Product> products;
		
		if ("priceAsc".equalsIgnoreCase(sort)) {
			products = productRepository.findAllByOrderByPriceAsc();
		}else if("priceDesc".equalsIgnoreCase(sort)) {
			products = productRepository.findAllByOrderByPriceDesc();
		}else {
			products = productRepository.findAll();
		}
		return products.stream().map(product -> {
			ProductResponseDto response = new ProductResponseDto();
			response.setId(product.getId());
			response.setBrand(product.getBrand());
			response.setModel(product.getModel());
			response.setCategory(product.getCategory());
			response.setDescription(product.getDescription());
			response.setPrice(product.getPrice());
			response.setRating(product.getRating());
			response.setImage(product.getImage());
			return response;
		})
				.collect(Collectors.toList());
	}
}
