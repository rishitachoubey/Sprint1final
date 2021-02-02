package com.cg.onlinegrocery.exception;

public class InsufficientItemsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientItemsException() {

		super();

	}

	public InsufficientItemsException(String errMsg) {

		super(errMsg);

	}

}
