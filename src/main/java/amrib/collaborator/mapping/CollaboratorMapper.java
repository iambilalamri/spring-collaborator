package amrib.collaborator.mapping;

import org.mapstruct.Mapper;

import amrib.collaborator.dto.CollaboratorDTO;
import amrib.collaborator.entity.CollaboratorEntity;

@Mapper
public interface CollaboratorMapper {

	CollaboratorEntity toEntity(CollaboratorDTO dto);

	CollaboratorDTO toDto(CollaboratorEntity entity);

}
