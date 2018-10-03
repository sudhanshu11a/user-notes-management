/**
 * 
 */
package org.gotprint.assignment.usernotesmanagement.service_api.common.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

	@NotNull(message="The field must not be null")
	@Size(min=8,  message = "The field must be at least {min} characters")
	private String title;

	@NotNull(message="The field must not be null")
	@Size(max=1000, message = "The field must be at max {max} characters")
	private String note;

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
		this.title = title.trim();
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
		this.note = note.trim();
	}

}
