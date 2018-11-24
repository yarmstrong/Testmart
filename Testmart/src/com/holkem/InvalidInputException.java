package com.holkem;

public class InvalidInputException extends Exception {
	private static final long serialVersionUID = 1L; // required
	private String errorDetails;

	public InvalidInputException(String reason, String errorDetails) {
		super(reason);
		this.errorDetails = errorDetails;
	}
	
	public String getFaultInfo() {
		return errorDetails;
	}
}
