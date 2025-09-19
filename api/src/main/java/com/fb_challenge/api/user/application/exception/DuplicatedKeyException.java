package com.fb_challenge.api.user.application.exception;

public class DuplicatedKeyException extends RuntimeException {
   	public DuplicatedKeyException(String message) {
		super(message);
	}
	
	public DuplicatedKeyException(String message, Throwable cause) {
		super(message, cause);
	}
}
