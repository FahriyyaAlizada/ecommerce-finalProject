package com.example.ecommerce_final_backEnd.response;

import java.util.List;

public class ExceptionResponse {
	private String message;
	private List<ValidationResponse> validations;
	
	public ExceptionResponse() {
		// TODO Auto-generated constructor stub
	}

	public ExceptionResponse(String message, List<ValidationResponse> validations) {
		super();
		this.message = message;
		this.validations = validations;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ValidationResponse> getValidations() {
		return validations;
	}

	public void setValidations(List<ValidationResponse> validations) {
		this.validations = validations;
	}
	
	
}
