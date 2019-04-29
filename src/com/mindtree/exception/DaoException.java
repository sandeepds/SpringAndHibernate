/**
 * 
 */
package com.mindtree.exception;

/**
 * @author SSatpath
 *
 */
@SuppressWarnings("serial")
public class DaoException extends ServiceException {

	/**
	 * 
	 */
	public DaoException() {
		
	}

	/**
	 * @param message
	 */
	public DaoException(String message) {
		super(message);
		
	}

	/**
	 * @param cause
	 */
	public DaoException(Throwable cause) {
		super(cause);
	
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public DaoException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
