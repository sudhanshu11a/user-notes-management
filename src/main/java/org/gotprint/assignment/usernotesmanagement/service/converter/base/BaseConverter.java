/**
 * 
 */
package org.gotprint.assignment.usernotesmanagement.service.converter.base;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This is base converter interface for converting the Entity to DTO and vice-versa. 
 * We have used the Transfer Object Pattern 
 * 
 * @author sudhanshusharma
 *
 */
public interface BaseConverter<DTO, E> {

	DTO convertToDTO(E entity);

	E convertToEntity(DTO dto);

	default List<DTO> convertToDTOList(List<E> entities) {
		return entities.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	default List<E> convertToEntityList(List<DTO> dtos, Long organizationId) {
		return dtos.stream().map(this::convertToEntity).collect(Collectors.toList());
	}
}
