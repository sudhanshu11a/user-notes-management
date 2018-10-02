/**
 * 
 */
package org.gotprint.assignment.usernotesmanagement.service_api.exception;

/**
 * Exception message indicating that there is no such resource which client is
 * requesting.
 * 
 * @author sudhanshusharma
 *
 */
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1443039300306902155L;

	/**
	 * Constructs an {@code ApiException} with the specified message and root cause.
	 *
	 * @param msg the detail message
	 * @param t   the root cause
	 */
	public ResourceNotFoundException(String msg, Throwable t) {
		super(msg, t);
	}

	/**
	 * Constructs an {@code ApiException} with the specified message and no root
	 * cause.
	 *
	 * @param msg the detail message
	 */
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
