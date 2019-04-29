/**
 * 
 */
package com.mindtree.exception;

/**
 * @author SSatpath
 *
 */
public class PersistenceException extends DaoException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public PersistenceException() {
		
	}

	/**
	 * @param message
	 */
	public PersistenceException(String message) {
		super(message);
		
	}

	/**
	 * @param cause
	 */
	public PersistenceException(Throwable cause) {
		super(cause);
		
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PersistenceException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public PersistenceException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
