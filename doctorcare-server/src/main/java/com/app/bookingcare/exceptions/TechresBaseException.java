package com.app.bookingcare.exceptions;

public class TechresBaseException extends Exception {
	static final long serialVersionUID = -3387516993124229948L;

	public TechresBaseException(String errorMessage) {
		super(errorMessage);
	}
}
