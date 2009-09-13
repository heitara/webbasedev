package com.gameif.common.exception;

public class AuthorityException extends LogicException {

	private static final long serialVersionUID = 5216526290862087683L;
	
	public AuthorityException() {
		
		super();
	}
	
	public AuthorityException(String message) {
		
		super(message);
	}
	
	public AuthorityException(Throwable cause) {
		
		super(cause);
	}
	
	public AuthorityException(String message, Throwable cause) {
		
		super(message, cause);
	}
}
