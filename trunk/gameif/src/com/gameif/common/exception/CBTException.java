package com.gameif.common.exception;

public class CBTException extends LogicException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -890997822394407919L;
	
	public CBTException() {
		
		super();
	}
	
	public CBTException(String message) {
		
		super(message);
	}
	
	public CBTException(Throwable cause) {
		
		super(cause);
	}
	
	public CBTException(String message, Throwable cause) {
		
		super(message, cause);
	}

}
