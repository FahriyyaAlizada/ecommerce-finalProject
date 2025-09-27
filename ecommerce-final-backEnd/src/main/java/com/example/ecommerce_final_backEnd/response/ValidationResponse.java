package com.example.ecommerce_final_backEnd.response;

public class ValidationResponse {
	private String field;
	private String defaultMessage;
	
	public ValidationResponse() {
		// TODO Auto-generated constructor stub
	}

	public ValidationResponse(String field, String defaultMessage) {
		super();
		this.field = field;
		this.defaultMessage = defaultMessage;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getDefaultMessage() {
		return defaultMessage;
	}

	public void setDefaultMessage(String defaultMessage) {
		this.defaultMessage = defaultMessage;
	}
	
	
}
