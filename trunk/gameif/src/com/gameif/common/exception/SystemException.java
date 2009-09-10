package com.gameif.common.exception;

public class SystemException extends RuntimeException {

	private static final long serialVersionUID = -1545868839110026908L;
	
	public SystemException() {
		
		super();
	}
	
	public SystemException(String message) {
		
		super(message);
	}
	
	public SystemException(Throwable cause) {
		
		super(cause);
	}
	
	public SystemException(String message, Throwable cause) {
		
		super(message, cause);
	}

}
