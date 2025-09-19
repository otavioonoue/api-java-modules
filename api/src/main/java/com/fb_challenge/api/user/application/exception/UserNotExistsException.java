package com.fb_challenge.api.user.application.exception;

public class UserNotExistsException extends RuntimeException {
    public UserNotExistsException(String message) {
        super(message);
    }
    
    public UserNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }
	
}
