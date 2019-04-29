/**
 * 
 */
package com.mindtree.exception;

/**
 * @author SSatpath
 *
 */
@SuppressWarnings("serial")
public class ServiceException extends ApplicationException {

	/**
	 * 
	 */
	public ServiceException() {
	
	}

	/**
	 * @param message
	 */
	public ServiceException(String message) {
		super(message);
		
	}

	/**
	 * @param cause
	 */
	public ServiceException(Throwable cause) {
		super(cause);
		
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ServiceException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
