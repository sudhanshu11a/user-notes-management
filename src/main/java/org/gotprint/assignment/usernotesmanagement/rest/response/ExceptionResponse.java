/**
 * 
 */
package org.gotprint.assignment.usernotesmanagement.rest.response;

/**
 * This is a Response object containing the Exception details. 
 *   
 * @author sudhanshusharma
 *
 */
public class ExceptionResponse {

	private String errorCode;
    private String errorMessage;
 
    public ExceptionResponse() {
    }
 
    public String getErrorCode() {
        return errorCode;
    }
 
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
 
    public String getErrorMessage() {
        return errorMessage;
    }
 
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
