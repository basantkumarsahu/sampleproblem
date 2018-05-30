package com.accolite.exception;

public class Error extends RuntimeException{
	private int erroeCode;
	private String errorMessage;
	
	public Error(String message, Throwable cause, int erroeCode) {
		super(message, cause);
		this.erroeCode = erroeCode;
		this.errorMessage = message;
	}

	public int getErroeCode() {
		return erroeCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	
	
}
