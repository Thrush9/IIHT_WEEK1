package com.marksapp.main.exception;

public class StudentAlreadyExistsException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public StudentAlreadyExistsException(String message) {
		super(message);
	}

}
