package com.github.miajrush.university.web.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Controller used to showcase what happens when an exception is thrown.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Throwable.class)
	public String handle() {
		return "error";
	}
}
