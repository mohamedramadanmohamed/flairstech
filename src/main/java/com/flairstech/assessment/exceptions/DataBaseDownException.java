package com.flairstech.assessment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class DataBaseDownException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1039131913504202707L;

	public DataBaseDownException(String message) {
		super(message);
	}
}
