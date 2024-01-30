package com.crudOperation.PatientRecord.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;




@RestControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	  @ResponseStatus(value = HttpStatus.NOT_FOUND)
	  public ResponseEntity<ErrorMessage>  resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	        HttpStatus.NOT_FOUND.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<ErrorMessage>(message,HttpStatus.NOT_FOUND);
	    

	  }
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<com.crudOperation.PatientRecord.payload.ApiResponse> handleApiException(ApiException ex){
		String message = ex.getMessage();
		com.crudOperation.PatientRecord.payload.ApiResponse apiResponse = new com.crudOperation.PatientRecord.payload.ApiResponse(message,true);
		return new ResponseEntity<com.crudOperation.PatientRecord.payload.ApiResponse>(apiResponse,HttpStatus.BAD_REQUEST);
	}
	
	  
	  @ExceptionHandler(Exception.class)
	  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	  public ErrorMessage globalExceptionHandler(Exception ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	        HttpStatus.INTERNAL_SERVER_ERROR.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return message;
	  }
	  

}
