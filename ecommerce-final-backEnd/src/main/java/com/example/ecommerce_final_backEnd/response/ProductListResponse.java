package com.example.ecommerce_final_backEnd.response;

import java.util.List;

import com.example.ecommerce_final_backEnd.entity.Product;

public class ProductListResponse {
	private List<Product> products;
	
	public ProductListResponse() {
		// TODO Auto-generated constructor stub
	}

	public ProductListResponse(List<Product> products) {
		super();
		this.products = products;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
