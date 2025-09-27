package com.example.ecommerce_final_backEnd.response;

import com.example.ecommerce_final_backEnd.entity.Product;

public class CartResponseDto {
	private Integer id;
	private Integer quantity;
	private Double subTotal;
	private Product product;
	
	private Integer userId;
	
	public CartResponseDto() {
		// TODO Auto-generated constructor stub
	}

	public CartResponseDto(Integer id, Integer quantity, Double subTotal, Product product, Integer userId) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.subTotal = subTotal;
		this.product = product;
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
