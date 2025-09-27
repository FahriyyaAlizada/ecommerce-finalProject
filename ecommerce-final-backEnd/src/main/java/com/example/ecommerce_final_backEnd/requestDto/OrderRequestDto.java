package com.example.ecommerce_final_backEnd.requestDto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class OrderRequestDto {
	@NotNull
	private Integer cartId;
	@Size(min = 2, max = 20, message = "Firstname must be min 2 & max 20 characters")
	private String firstName;
	@Size(min = 2, max = 20, message = "Lastname must be min 2 & max 20 characters")
	private String lastName;
	@NotBlank(message = "Country cannot be blank")
	private String country;
	@NotBlank(message = "Address cannot be blank")
	private String address; 
	@NotBlank(message = "City cannot be blank")
	private String city;
	@NotBlank(message = "Phone cannot be blank")
	private String phone;
	@Pattern(regexp = "[a-zA-Z]+@[a-z]+\\.[a-z]{2,4}")
	private String email;
	@NotBlank(message = "Card number cannot be blank")
	private String cartNumber;
	@NotBlank(message = "Zip code cannot be blank")
	private String zipCode;
	@NotBlank(message = "Expiry month cannot be blank")
	private String expiryMonth;
	@NotNull(message = "Expiry year cannot be null")
	@Min(value = 23, message = "Expiry year must be greater than or equal to the current year")
	private Integer expiryYear;
	
	public OrderRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public OrderRequestDto(@NotNull Integer cartId,
			@Size(min = 2, max = 20, message = "Firstname must be min 2 & max 20 characters") String firstName,
			@Size(min = 2, max = 20, message = "Lastname must be min 2 & max 20 characters") String lastName,
			@NotBlank(message = "Country cannot be blank") String country,
			@NotBlank(message = "Address cannot be blank") String address,
			@NotBlank(message = "City cannot be blank") String city,
			@NotBlank(message = "Phone cannot be blank") String phone,
			@Pattern(regexp = "[a-zA-Z]+@[a-z]+\\.[a-z]{2,4}") String email,
			@NotBlank(message = "Card number cannot be blank") String cartNumber,
			@NotBlank(message = "Zip code cannot be blank") String zipCode,
			@NotBlank(message = "Expiry month cannot be blank") String expiryMonth,
			@NotNull(message = "Expiry year cannot be null") @Min(value = 23, message = "Expiry year must be greater than or equal to the current year") Integer expiryYear) {
		super();
		this.cartId = cartId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.address = address;
		this.city = city;
		this.phone = phone;
		this.email = email;
		this.cartNumber = cartNumber;
		this.zipCode = zipCode;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCartNumber() {
		return cartNumber;
	}

	public void setCartNumber(String cartNumber) {
		this.cartNumber = cartNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public Integer getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(Integer expiryYear) {
		this.expiryYear = expiryYear;
	}
	
	
}
