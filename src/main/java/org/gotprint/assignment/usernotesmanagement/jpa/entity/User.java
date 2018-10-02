/**
 * 
 */
package org.gotprint.assignment.usernotesmanagement.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.gotprint.assignment.usernotesmanagement.jpa.entity.base.BaseEntity;


/**
 * @author sudhanshusharma
 *
 */
@Entity
@Table(name="user")
public class User extends BaseEntity{

	@Column(name = "email", nullable = false, unique=true)
	private String email;

	@Column(name = "password", nullable = false)
	@Size(min=8,  message = "The password field must be at least {min} characters")
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
