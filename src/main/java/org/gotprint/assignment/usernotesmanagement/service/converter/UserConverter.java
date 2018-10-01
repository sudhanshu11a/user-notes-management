/**
 * 
 */
package org.gotprint.assignment.usernotesmanagement.service.converter;

import org.gotprint.assignment.usernotesmanagement.jpa.entity.User;
import org.gotprint.assignment.usernotesmanagement.service.converter.base.BaseConverter;
import org.gotprint.assignment.usernotesmanagement.service_api.common.dto.UserDTO;
import org.modelmapper.ModelMapper;

/**
 * @author sudhanshusharma
 *
 */
public class UserConverter implements BaseConverter<UserDTO, User> {

	private ModelMapper modelMapper;

	public UserConverter() {
		this.modelMapper = new ModelMapper();
	}

	@Override
	public UserDTO convertToDTO(User entity) {
		UserDTO dto = modelMapper.map(entity, UserDTO.class);
		return dto;
	}

	@Override
	public User convertToEntity(UserDTO dto) {
		User entity = modelMapper.map(dto, User.class);
		return entity;
	}
}
