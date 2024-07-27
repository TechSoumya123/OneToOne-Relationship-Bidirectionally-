package com.developer.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String error = "Request method " + ex.getMethod() + " not supported. Supported methods are "
				+ String.join(" ",ex.getSupportedMethods());
		ErrorResponse errorResponse = new ErrorResponse(error, HttpStatus.METHOD_NOT_ALLOWED.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> employeeNotFound(EmployeeNotFoundException employeeNotFoundException) {
		Map<String, String> error = new HashMap<>();
		error.put("error", employeeNotFoundException.getMessage());
		return error;
	}

	@ExceptionHandler(NoMobileFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> mobileNotFound(NoMobileFoundException noMobileFoundException) {
		Map<String, String> error = new HashMap<>();
		error.put("error", noMobileFoundException.getMessage());
		return error;
	}
}
