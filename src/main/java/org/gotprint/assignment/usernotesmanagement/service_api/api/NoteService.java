/**
 * 
 */
package org.gotprint.assignment.usernotesmanagement.service_api.api;

import java.util.List;

import org.gotprint.assignment.usernotesmanagement.service_api.common.dto.NoteDTO;
import org.gotprint.assignment.usernotesmanagement.service_api.exception.ServiceException;

/**
 * @author sudhanshusharma
 *
 */
public interface NoteService {
	
	List<NoteDTO> getAllNotes() throws ServiceException;

	List<NoteDTO> getUserAllNotes(long userId) throws ServiceException;
	
	NoteDTO getUserNoteDetail(long noteId, long userId) throws ServiceException;
	
	NoteDTO createUserNote(NoteDTO noteDTO, long userId) throws ServiceException;
	
	NoteDTO updateUserNote(NoteDTO noteDTO, long userId) throws ServiceException;
	
	void deleteUserNote(long noteId, long userId) throws ServiceException;
}
