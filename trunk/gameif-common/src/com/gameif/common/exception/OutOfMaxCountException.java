package com.gameif.common.exception;

public class OutOfMaxCountException extends LogicException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9002302927906976123L;
	
	public OutOfMaxCountException() {
		
		super();
	}
	
	public OutOfMaxCountException(String message) {
		
		super(message);
	}
	
	public OutOfMaxCountException(Throwable cause) {
		
		super(cause);
	}
	
	public OutOfMaxCountException(String message, Throwable cause) {
		
		super(message, cause);
	}

}
