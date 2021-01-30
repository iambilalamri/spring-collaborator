package amrib.collaborator.mapping;

import org.mapstruct.Mapper;

import amrib.collaborator.dto.CollaboratorDTO;
import amrib.collaborator.entity.CollaboratorEntity;


@Mapper
public interface CollaboratorMapper {

	public CollaboratorDTO toDto(CollaboratorEntity entity);

	public CollaboratorEntity toEntity(CollaboratorDTO dto);
}
