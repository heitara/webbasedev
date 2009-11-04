package com.gameif.common.exception;

public class OutOfDateException extends LogicException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7914235011960742409L;
	
	public OutOfDateException() {
		
		super();
	}
	
	public OutOfDateException(String message) {
		
		super(message);
	}
	
	public OutOfDateException(Throwable cause) {
		
		super(cause);
	}
	
	public OutOfDateException(String message, Throwable cause) {
		
		super(message, cause);
	}

}
