/**
 * 
 */
package org.gotprint.assignment.usernotesmanagement.service_api.common.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.gotprint.assignment.usernotesmanagement.service_api.common.dto.base.BaseDTO;

/**
 * @author sudhanshusharma
 *
 */
public class NoteDTO extends BaseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7718174244231513548L;

	@NotNull
	private String title;

	@NotNull
	private String note;

	// private Long userId;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

//	/**
//	 * @return the userId
//	 */
//	public Long getUserId() {
//		return userId;
//	}
//
//	/**
//	 * @param userId the userId to set
//	 */
//	public void setUserId(Long userId) {
//		this.userId = userId;
//	}

}
