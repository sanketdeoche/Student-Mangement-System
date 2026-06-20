package com.example.demo.globalexceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.CourseServiceException;
import com.example.demo.exception.TrainerServiceException;
import com.example.demo.exception.UsersServiceException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = UsersServiceException.class)
	ResponseEntity<String> handleUsersServiceException(UsersServiceException use) {
		return new ResponseEntity<String>(use.getMessage(), use.getHttpStatus());
	}

	@ExceptionHandler(exception = Exception.class)
	ResponseEntity<String> handleException(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(exception = CourseServiceException.class)
	ResponseEntity<String> handleCourseServiceException(CourseServiceException c) {
		return new ResponseEntity<String> (c.getMessage(),c.getHttpStatus());
	}

	@ExceptionHandler(exception = TrainerServiceException.class)
	ResponseEntity<String> handleCourseServiceException(TrainerServiceException t) {
		return new ResponseEntity<String>(t.getMessage(), t.getHtppHttpStatus());

	}
}
