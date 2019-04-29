/**
 * 
 */
package com.mindtree.exception;

/**
 * @author SSatpath
 *
 */
public class FetcherException extends DaoException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public FetcherException() {
		
	}

	/**
	 * @param message
	 */
	public FetcherException(String message) {
		super(message);
		
	}

	/**
	 * @param cause
	 */
	public FetcherException(Throwable cause) {
		super(cause);
		
	}

	/**
	 * @param message
	 * @param cause
	 */
	public FetcherException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public FetcherException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
