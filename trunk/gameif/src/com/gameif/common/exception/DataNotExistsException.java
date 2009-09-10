package com.gameif.common.exception;

public class DataNotExistsException extends LogicException {

	private static final long serialVersionUID = 5216526290862087683L;
	
	public DataNotExistsException() {
		
		super();
	}
	
	public DataNotExistsException(String message) {
		
		super(message);
	}
	
	public DataNotExistsException(Throwable cause) {
		
		super(cause);
	}
	
	public DataNotExistsException(String message, Throwable cause) {
		
		super(message, cause);
	}
}
