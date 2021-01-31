package amrib.collaborator.mapping;

import org.mapstruct.Mapper;

import amrib.collaborator.dto.CollaboratorDTO;
import amrib.collaborator.entity.CollaboratorEntity;

@Mapper
public interface CollaboratorMapper {

	public CollaboratorEntity toEntity(CollaboratorDTO dto);

	public CollaboratorDTO toDto(CollaboratorEntity entity);
}
