/**
 * 
 */
package org.gotprint.assignment.usernotesmanagement.service.converter;

import org.gotprint.assignment.usernotesmanagement.jpa.entity.Note;
import org.gotprint.assignment.usernotesmanagement.service_api.common.dto.NoteDTO;
import org.gotprint.assignment.usernotesmanagement.service.converter.base.BaseConverter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * Note converter for converting the entity to dto and vice-versa
 * 
 * @author sudhanshusharma
 *
 */
@Component
public class NoteConverter implements BaseConverter<NoteDTO, Note> {

	private ModelMapper modelMapper;

	public NoteConverter() {
		this.modelMapper = new ModelMapper();
	}
	@Override
	public NoteDTO convertToDTO(Note entity) {
		return entity!=null?modelMapper.map(entity, NoteDTO.class):null;
	}

	@Override
	public Note convertToEntity(NoteDTO dto) {
		return dto!=null?modelMapper.map(dto, Note.class):null;
	}
}
