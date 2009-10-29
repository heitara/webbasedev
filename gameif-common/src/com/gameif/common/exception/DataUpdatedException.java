package com.gameif.common.exception;

public class DataUpdatedException extends LogicException {

	private static final long serialVersionUID = 5216526290862087683L;
	
	public DataUpdatedException() {
		
		super();
	}
	
	public DataUpdatedException(String message) {
		
		super(message);
	}
	
	public DataUpdatedException(Throwable cause) {
		
		super(cause);
	}
	
	public DataUpdatedException(String message, Throwable cause) {
		
		super(message, cause);
	}
}
