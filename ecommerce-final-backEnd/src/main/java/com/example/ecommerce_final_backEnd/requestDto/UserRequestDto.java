package com.example.ecommerce_final_backEnd.requestDto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserRequestDto {
	private Integer id;
	@NotNull
	@Size(min = 2,max = 30,message = "name must be min 2 & max 30 characters")
	private String name;
	@NotNull
	@Size(min = 2,max = 30,message = "surname must be min 2 & max 30 characters")
	private String surname;
	@NotNull
	@Pattern(regexp = "[a-zA-Z]+@[a-z]+\\.[a-z]{2,4}")
	private String email;
	@NotNull
	@Size(min = 2,max = 30,message = "username must be min 2 & max 30 characters")
	private String username;
	@NotNull
	@Size(min = 2,max = 30,message = "password must be min 2 & max 30 characters")
	private String password;
	
	public UserRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public UserRequestDto(Integer id,
			@NotNull @Size(min = 2, max = 30, message = "name must be min 2 & max 30 characters") String name,
			@NotNull @Size(min = 2, max = 30, message = "surname must be min 2 & max 30 characters") String surname,
			@NotNull @Pattern(regexp = "[a-zA-Z]+@[a-z]+\\.[a-z]{2,4}") String email,
			@NotNull @Size(min = 2, max = 30, message = "username must be min 2 & max 30 characters") String username,
			@NotNull @Size(min = 2, max = 30, message = "password must be min 2 & max 30 characters") String password) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
