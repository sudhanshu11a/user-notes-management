/**
 * 
 */
package org.gotprint.assignment.usernotesmanagement.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;

import org.gotprint.assignment.usernotesmanagement.service_api.common.dto.NoteDTO;
import org.gotprint.assignment.usernotesmanagement.service.converter.NoteConverter;
import org.gotprint.assignment.usernotesmanagement.service_api.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.gotprint.assignment.usernotesmanagement.jpa.entity.Note;
import org.gotprint.assignment.usernotesmanagement.jpa.repository.NoteRepository;
import org.gotprint.assignment.usernotesmanagement.jpa.repository.UserRepository;
import org.gotprint.assignment.usernotesmanagement.service_api.api.NoteService;

/**
 * It is a Note Service implementation for the note service.
 * 
 * @author sudhanshusharma
 *
 */
@Service
@Transactional
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteRepository noteRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private NoteConverter noteConverter;

	@Override
	public List<NoteDTO> getAllNotes() throws ServiceException {
		List<NoteDTO> noteDTOs = null;
		List<Note> notes = null;
		try {
			notes = noteRepository.findAll();
			noteDTOs = noteConverter.convertToDTOList(notes);
		} catch (Exception ex) {
			throw new ServiceException("Exception in fetching all notes.", ex);
		}
		return noteDTOs;
	}

	@Override
	public List<NoteDTO> getUserAllNotes(String username) throws ServiceException {
		List<NoteDTO> noteDTOs = null;
		List<Note> notes = null;
		try {
			notes = noteRepository.findByUserName(username.trim());
			noteDTOs = noteConverter.convertToDTOList(notes);
		} catch (Exception ex) {
			throw new ServiceException("Exception in fetching all user notes.", ex);
		}
		return noteDTOs;
	}

	@Override
	public NoteDTO getUserNoteDetail(long noteId, String username) throws ServiceException {
		NoteDTO noteDTO = null;
		Note note = null;
		try {
			note = noteRepository.findByIdAndUsername(noteId, username.trim());
			noteDTO = noteConverter.convertToDTO(note);
		} catch (Exception ex) {
			throw new ServiceException("Exception in fetching note : " + noteId, ex);
		}
		return noteDTO;
	}

	@Override
	public NoteDTO createUserNote(NoteDTO noteDTO, String username) throws ServiceException {
		Note note = null;
		try {
			if (noteDTO != null && noteDTO.getId() == null) {
				note = noteConverter.convertToEntity(noteDTO);
				note.setUserId(userRepository.findByEmail(username).getId());
				note = noteRepository.saveAndFlush(note);
				noteDTO = noteConverter.convertToDTO(note);
			}
		} catch (ConstraintViolationException ex) {
			throw new ConstraintViolationException(ex.getConstraintViolations());
		} catch (Exception ex) {
			throw new ServiceException("Exception in creating note.", ex);
		}
		return noteDTO;
	}

	@Override
	public NoteDTO updateUserNote(NoteDTO noteDTO, String username) throws ServiceException {
		try {
			Note note = noteRepository.findByIdAndUsername(noteDTO.getId(), username.trim());
			if (note != null) {
				Date createdDate = note.getCreatedDate();
				note = noteConverter.convertToEntity(noteDTO);
				note.setCreatedDate(createdDate);
				note.setUserId(userRepository.findByEmail(username).getId());
				noteRepository.saveAndFlush(note);
			}else {
				noteDTO = null;
			}
		} catch (ConstraintViolationException ex) {
			throw new ConstraintViolationException(ex.getConstraintViolations());
		} catch (Exception ex) {
			throw new ServiceException("Exception in updating User Note :" + noteDTO.getId(), ex);
		}
		return noteDTO;
	}

	@Override
	public boolean deleteUserNote(long noteId, String username) throws ServiceException {
		boolean success = false;
		try {
			Note note = noteRepository.findByIdAndUsername(noteId, username.trim());
			if (note != null) {
				noteRepository.delete(note);
				success= true;
			}
		} catch (Exception ex) {
			throw new ServiceException("Exception in deleting note :" + noteId, ex);
		}
		return success;
	}

}
