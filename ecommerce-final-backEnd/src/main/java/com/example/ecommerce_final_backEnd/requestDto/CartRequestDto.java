package com.example.ecommerce_final_backEnd.requestDto;

public class CartRequestDto {
	private Integer id;
	private Integer productId;
	private Integer quantity;
	private Double subTotal;
	
	public CartRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public CartRequestDto(Integer id, Integer productId, Integer quantity, Double subTotal) {
		super();
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.subTotal = subTotal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
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
	
	
}
