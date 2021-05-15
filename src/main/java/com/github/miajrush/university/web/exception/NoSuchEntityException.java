package com.github.miajrush.university.web.exception;

public class NoSuchEntityException extends RuntimeException {
	public static final String MESSAGE = "%s with ID = %d is not found.";
	
	public NoSuchEntityException(Class<?> classObj, Integer id) {
		super(String.format(MESSAGE, classObj.getSimpleName(), id));
	}
}
