package com.example.ecommerce_final_backEnd.exception;

import org.springframework.validation.BindingResult;

public class OurRuntimeException extends RuntimeException{
	private BindingResult br;

	public OurRuntimeException(BindingResult br,String message) {
		super(message);
		this.br = br;
	}
	
	public BindingResult getBr() {
		return br;
	}
}
