/**
 * 
 */
package org.gotprint.assignment.usernotesmanagement.rest.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.gotprint.assignment.usernotesmanagement.service_api.api.NoteService;
import org.gotprint.assignment.usernotesmanagement.service_api.common.dto.NoteDTO;
import org.gotprint.assignment.usernotesmanagement.service_api.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Note controller for handling rest requests for the Not resource
 * 
 * TODO: This is a secure resource, so we need to implement the authentication.
 * 
 * @author sudhanshusharma
 *
 */
@RestController
@RequestMapping("api/v1/secure/user/notes")
public class NoteRestController {

	@Autowired
	private NoteService noteService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@GetMapping()
	public List<NoteDTO> getUserNotes() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		List<NoteDTO> noteDTOs = noteService.getUserAllNotes(username);
		if (noteDTOs == null || noteDTOs.isEmpty()) {
			throw new ResourceNotFoundException("No notes not found for current user!");
		}
		return noteDTOs;
	}

	@PostMapping()
	public NoteDTO saveUserNote(@Valid NoteDTO noteDTO) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		noteDTO = noteService.createUserNote(noteDTO, username);
		if (noteDTO == null) {
			throw new ResourceNotFoundException("Service is only for new Notes");
		}
		return noteDTO;
	}

	@GetMapping("/{id}")
	public NoteDTO getUserNotedetails(@PathVariable("id") long noteId) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		NoteDTO noteDTO = noteService.getUserNoteDetail(noteId, username);
		if (noteDTO == null) {
			throw new ResourceNotFoundException("Note not found!");
		}
		return noteDTO;
	}

	@PutMapping("/{id}")
	public NoteDTO updateUserNote(@Valid NoteDTO noteDTO, @PathVariable("id") long noteId) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		noteDTO = noteService.updateUserNote(noteDTO, username);
		if (noteDTO == null) {
			throw new ResourceNotFoundException("Note not found!");
		}
		return noteDTO;
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteUserNote(@PathVariable("id") long noteId) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		boolean success = noteService.deleteUserNote(noteId, username);
		if(!success) {
			throw new ResourceNotFoundException("Note not found!");
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
