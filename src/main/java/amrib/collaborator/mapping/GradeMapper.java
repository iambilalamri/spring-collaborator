package amrib.collaborator.mapping;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import amrib.collaborator.dto.GradeDTO;
import amrib.collaborator.entity.GradeEntity;

@Mapper(componentModel = "spring")
public interface GradeMapper {

	public GradeDTO toDto(GradeEntity entity);

	@InheritInverseConfiguration
	public GradeEntity toEntity(GradeDTO dto);
}
