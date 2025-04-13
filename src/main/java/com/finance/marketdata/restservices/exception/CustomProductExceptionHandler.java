package com.finance.marketdata.restservices.exception;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.finance.marketdata.restservices.models.ErrorDetailsRecord;


@ControllerAdvice
public class CustomProductExceptionHandler extends ResponseEntityExceptionHandler{
	
	Logger logger = LoggerFactory.getLogger(CustomProductExceptionHandler.class);
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetailsRecord> handleAllExceptions(Exception ex, WebRequest request){
		 
		return new ResponseEntity<ErrorDetailsRecord> (new ErrorDetailsRecord(LocalDateTime.now(),
				ex.getMessage(), request.getDescription(false)), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public final ResponseEntity<ErrorDetailsRecord> handleProductNotFoundException(Exception ex, 
			WebRequest request) throws Exception {
		
		return new ResponseEntity<ErrorDetailsRecord>(new ErrorDetailsRecord(LocalDateTime.now(),
				ex.getMessage(), request.getDescription(false)), HttpStatus.NOT_FOUND);
		
	}
	
	@Override	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, 
			HttpStatusCode status, WebRequest request ) {
		
		StringBuilder messages=new StringBuilder("");
		
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			messages.append(error.getDefaultMessage()).append(". ");
	    });
		
		
		return handleExceptionInternal(ex, new ErrorDetailsRecord(LocalDateTime.now(),
				  messages.toString(), request.getDescription(false)), headers, status, request);
		
		/*
		 * return new ResponseEntity<Object>(new ErrorDetailsRecord(LocalDateTime.now(),
		 * messages.toString(), request.getDescription(false)), HttpStatus.BAD_REQUEST);
		 */
		
	}
	

}
