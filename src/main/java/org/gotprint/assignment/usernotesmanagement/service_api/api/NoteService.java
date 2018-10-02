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

	List<NoteDTO> getUserAllNotes(String username) throws ServiceException;
	
	NoteDTO getUserNoteDetail(long noteId, String username) throws ServiceException;
	
	NoteDTO createUserNote(NoteDTO noteDTO, String username) throws ServiceException;
	
	NoteDTO updateUserNote(NoteDTO noteDTO, String username) throws ServiceException;
	
	boolean deleteUserNote(long noteId, String username) throws ServiceException;
}
