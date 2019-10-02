package com.educandoweb.course.services.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.course.resources.exception.StandardError;

// Classe para tratar error nas possiveis requisições
@ControllerAdvice
public class ResourceExceptionHandler {
	
	// Declarando metafo
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", 
				e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
