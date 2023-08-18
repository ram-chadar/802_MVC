package com.jbk.shopify.exceptions;

import java.util.HashMap;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public HashMap<String, Object> beanValidation(MethodArgumentNotValidException e) {
		HashMap<String, Object> map=new HashMap<>();
		
		
		BindingResult bindingResult = e.getBindingResult();
	 List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		
		for (FieldError fieldError : fieldErrors) {
			map.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		return map;
		
	}

}
