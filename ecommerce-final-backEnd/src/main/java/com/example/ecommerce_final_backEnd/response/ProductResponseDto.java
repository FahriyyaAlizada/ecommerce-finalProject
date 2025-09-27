package com.example.ecommerce_final_backEnd.response;


public class ProductResponseDto {
	private Integer id;
	private String brand;
	private String model;
	private String category;
	private String description;
	private Double price;
	private Integer rating;
	private String image;
	
	public ProductResponseDto() {
		// TODO Auto-generated constructor stub
	}

	public ProductResponseDto(Integer id, String brand, String model, String category, String description, Double price,
			Integer rating, String image) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.category = category;
		this.description = description;
		this.price = price;
		this.rating = rating;
		this.image = image;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
