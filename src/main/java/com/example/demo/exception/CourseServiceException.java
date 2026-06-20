package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class CourseServiceException extends RuntimeException {

	private String message;
	private HttpStatus httpStatus;

	public CourseServiceException(String message, HttpStatus httpStatus) {

		this.message = message;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
