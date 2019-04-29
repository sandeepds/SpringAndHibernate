package com.mindtree.exception;

@SuppressWarnings("serial")
public class ApplicationException extends Exception
{
	/**
	 * 
	 */
	public ApplicationException() {
		
	}

	/**
	 * @param message
	 */
	public ApplicationException(String message) {
		super(message);
		
	}

	/**
	 * @param cause
	 */
	public ApplicationException(Throwable cause) {
		super(cause);
		
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ApplicationException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super();
	
	}
}
