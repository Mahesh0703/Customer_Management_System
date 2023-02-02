package com.cust_mang_syst;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cust.mang.syst.exception.ErrorResponse;
import com.cust.mang.syst.exception.NoSuchCustomerExistException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NoSuchCustomerExistException.class)
	protected ResponseEntity<?> handleNoSuchFrieneExistException(NoSuchCustomerExistException ex,
			HttpServletRequest request) {

		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setErrorMassage(ex.getMessage());
		errorResponse.setRequestUri(request.getServletPath());
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setTimeStamp(new Date());

		return ResponseEntity.ok(errorResponse);
	}
}
