/**
 * 
 */
package org.gotprint.assignment.usernotesmanagement.rest.advice;

import org.gotprint.assignment.usernotesmanagement.rest.response.ExceptionResponse;
import org.gotprint.assignment.usernotesmanagement.service_api.exception.ResourceNotFoundException;
import org.gotprint.assignment.usernotesmanagement.service_api.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Global Application exception handler
 * 
 * 400 Bad Request – the request could not be understood. 401 Unauthorized – the
 * request require user authorization. 403 Forbidden – the server refusing to
 * fulfill the request. 404 Not found – the server can not find anything that
 * related to the request ( ex:- try to get user by id that not in the server).
 * 409 Conflict – the request can not be completed due to a resource conflict. (
 * ex:- user id already exist). 417 Expectation Failed - the request con not be
 * completed due to something goes wrong in the application (ex:- unexpected
 * Exception).
 * 
 * @author sudhanshusharma
 *
 */
@RestControllerAdvice
public class GlobalNotesManagementRestExceptionHandler extends ResponseEntityExceptionHandler {

	Logger logger = LoggerFactory.getLogger(GlobalNotesManagementRestExceptionHandler.class);

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("Not Found");
		response.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ExceptionResponse> serviceException(ServiceException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("Some thing goes wrong with application services!");
		logger.error("ServiceException : ", ex);
		response.setErrorMessage(
				"Something goes wrong with application services, please contect the application owner");
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.EXPECTATION_FAILED);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> allOtherException(Exception ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("Some thing goes wrong!");
		logger.error("Exception : ", ex);
		response.setErrorMessage("Something goes worg, please contect the application owner");
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.EXPECTATION_FAILED);
	}

}
