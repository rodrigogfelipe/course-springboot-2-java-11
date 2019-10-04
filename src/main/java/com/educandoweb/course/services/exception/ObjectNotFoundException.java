package com.educandoweb.course.services.exception;
/* ObjectNotFoundException lança as exceções */
public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}

}
