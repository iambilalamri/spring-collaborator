package amrib.collaborator.mapping;

import org.springframework.stereotype.Component;

import amrib.collaborator.dto.CollaboratorDTO;
import amrib.collaborator.entity.CollaboratorEntity;

@Component
public class CollaboratorMapper {
	
	public CollaboratorMapper() {
		// TODO Auto-generated constructor stub
	}

	public CollaboratorDTO toDto(CollaboratorEntity entity) {
		if (entity == null) {
			return null;
		}
		return new CollaboratorDTO(entity.getFirstname(), entity.getLastname(), entity.getEmail());
	}

	public static CollaboratorEntity toEntity(CollaboratorDTO dto) {
		if (dto == null) {
			return null;
		}
		return new CollaboratorEntity(dto.getFirstname(), dto.getLastname(), dto.getEmail());
	}
}
