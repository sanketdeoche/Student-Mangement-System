package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class TrainerServiceException extends RuntimeException {

	String message;
	HttpStatus htppHttpStatus;

	public TrainerServiceException(String message, HttpStatus htppHttpStatus) {

		this.message = message;
		this.htppHttpStatus = htppHttpStatus;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getHtppHttpStatus() {
		return htppHttpStatus;
	}

}
