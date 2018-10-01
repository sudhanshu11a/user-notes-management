/**
 * 
 */
package org.gotprint.assignment.usernotesmanagement.service_api.common.dto.base;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author sudhanshusharma
 *
 */
public abstract class BaseDTO implements Serializable{

	private static final long serialVersionUID = 8002080636214707471L;

	/** The id. */
	private Long id;

	/** The created date. */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdDate;

	/** The modified date. */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date modifiedDate;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the modifiedDate
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
