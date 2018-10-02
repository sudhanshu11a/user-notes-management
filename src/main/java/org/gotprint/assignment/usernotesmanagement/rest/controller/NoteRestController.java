/**
 * 
 */
package org.gotprint.assignment.usernotesmanagement.rest.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.gotprint.assignment.usernotesmanagement.service_api.api.NoteService;
import org.gotprint.assignment.usernotesmanagement.service_api.common.dto.NoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
	
	private long userId = 1l;

	@Autowired
	private NoteService noteService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
	    binder.registerCustomEditor(Date.class, editor);
	}

	@GetMapping()
	public List<NoteDTO> getUserNotes() {
		List<NoteDTO> noteDTOs = noteService.getUserAllNotes(userId);
		return noteDTOs;
	}
	
	@PostMapping()
	public NoteDTO saveUserNote(NoteDTO noteDTO) {
		noteDTO = noteService.createUserNote(noteDTO, userId);
		return noteDTO;
	}


	@GetMapping("/{id}")
	public NoteDTO getUserNotedetails(@PathVariable("id") long noteId) {
		NoteDTO noteDTO = noteService.getUserNoteDetail(noteId, userId);
		return noteDTO;
	}

	
	@PutMapping("/{id}")
	public NoteDTO updateUserNote(NoteDTO noteDTO, @PathVariable("id") long noteId) {
		noteDTO = noteService.updateUserNote(noteDTO, userId);
		return noteDTO;
	}

	@DeleteMapping("{id}")
	public void deleteUserNote(long noteId) {
		noteService.deleteUserNote(noteId, userId);
	}

}
