/**
 * 
 */
package org.gotprint.assignment.usernotesmanagement.service_api.api;

import org.gotprint.assignment.usernotesmanagement.service_api.exception.ServiceException;
import org.gotprint.assignment.usernotesmanagement.service_api.common.dto.UserDTO;

/**
 * @author sudhanshusharma
 *
 */
public interface UserService 
{
	
	UserDTO createUser(UserDTO userDTO) throws ServiceException;
	
	UserDTO validateUser(UserDTO userDTO) throws ServiceException;
}
