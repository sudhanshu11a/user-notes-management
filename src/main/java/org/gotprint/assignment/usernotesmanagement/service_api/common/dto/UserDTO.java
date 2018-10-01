/**
 * 
 */
package org.gotprint.assignment.usernotesmanagement.service_api.common.dto;

import java.io.Serializable;
import java.util.Collection;

import org.gotprint.assignment.usernotesmanagement.service_api.common.dto.base.BaseDTO;

/**
 * @author sudhanshusharma
 *
 */
public class UserDTO extends BaseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8261267368172027374L;

	private String email;

	private String password;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
