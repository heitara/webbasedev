package com.gameif.common.exception;

public class MaintenanceException extends LogicException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2258891841857945630L;
	
	public MaintenanceException() {
		
		super();
	}
	
	public MaintenanceException(String message) {
		
		super(message);
	}
	
	public MaintenanceException(Throwable cause) {
		
		super(cause);
	}
	
	public MaintenanceException(String message, Throwable cause) {
		
		super(message, cause);
	}

}
