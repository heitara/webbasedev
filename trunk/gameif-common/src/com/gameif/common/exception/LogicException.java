package com.gameif.common.exception;

public class LogicException extends Exception {

	private static final long serialVersionUID = 5216526290862087683L;
	
	public LogicException() {
		
		super();
	}
	
	public LogicException(String message) {
		
		super(message);
	}
	
	public LogicException(Throwable cause) {
		
		super(cause);
	}
	
	public LogicException(String message, Throwable cause) {
		
		super(message, cause);
	}
}
