package com.netcracker.customexception;

public class DatabaseException extends Exception {
	
	
	private static final long serialVersionUID = 1L;

	public DatabaseException() {
		
	}
	
	public DatabaseException(String msg) {
		super(msg);
	}

}
