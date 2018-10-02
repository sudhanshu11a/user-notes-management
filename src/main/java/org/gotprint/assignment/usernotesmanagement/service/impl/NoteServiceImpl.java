/**
 * 
 */
package org.gotprint.assignment.usernotesmanagement.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.gotprint.assignment.usernotesmanagement.service_api.common.dto.NoteDTO;
import org.gotprint.assignment.usernotesmanagement.service.converter.NoteConverter;
import org.gotprint.assignment.usernotesmanagement.service_api.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.gotprint.assignment.usernotesmanagement.jpa.entity.Note;
import org.gotprint.assignment.usernotesmanagement.jpa.repository.NoteRepository;
import org.gotprint.assignment.usernotesmanagement.service_api.api.NoteService;

/**
 * @author sudhanshusharma
 *
 */
@Service
@Transactional
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteRepository noteRepository;

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
			throw new ServiceException("Exception is getAllNotes.", ex);
		}
		return noteDTOs;
	}

	@Override
	public List<NoteDTO> getUserAllNotes(long userId) throws ServiceException {
		List<NoteDTO> noteDTOs = null;
		List<Note> notes = null;
		try {
			notes = noteRepository.findByUserId(userId);
			noteDTOs = noteConverter.convertToDTOList(notes);
		} catch (Exception ex) {
			throw new ServiceException("Exception is getAllNotes.", ex);
		}
		return noteDTOs;
	}

	@Override
	public NoteDTO getUserNoteDetail(long noteId, long userId) throws ServiceException {
		NoteDTO noteDTO = null;
		Note note = null;
		try {
			note = noteRepository.findByIdAndUserId(noteId, userId);
			noteDTO = noteConverter.convertToDTO(note);
		} catch (Exception ex) {
			throw new ServiceException("Exception is getUserNoteDetail.", ex);
		}
		return noteDTO;
	}

	@Override
	public NoteDTO createUserNote(NoteDTO noteDTO, long userId) throws ServiceException {
		Note note = null;
		try {
			note = noteConverter.convertToEntity(noteDTO);
			note = noteRepository.saveAndFlush(note);
			noteDTO = noteConverter.convertToDTO(note);
		} catch (Exception ex) {
			throw new ServiceException("Exception is getUserNoteDetail:", ex);
		}
		return noteDTO;
	}

	@Override
	public NoteDTO updateUserNote(NoteDTO noteDTO, long userId) throws ServiceException {
		try {
			int i = noteRepository.updateNote(noteDTO.getTitle(), noteDTO.getNote(), noteDTO.getId(),
					userId);
			if(i<1) {
				noteDTO = null;
			}
		} catch (Exception ex) {
			throw new ServiceException("Exception is updateUserNote:", ex);
		}
		return noteDTO;
	}

	@Override
	public void deleteUserNote(long noteId, long userId) throws ServiceException {
		try {
			noteRepository.deleteByIdAndUserId(noteId, userId);
		} catch (Exception ex) {
			throw new ServiceException("Exception is deleteUserNote:", ex);
		}

	}

}
