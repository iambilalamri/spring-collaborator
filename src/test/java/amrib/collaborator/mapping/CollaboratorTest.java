package amrib.collaborator.mapping;

import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import amrib.collaborator.dto.CollaboratorDTO;
import amrib.collaborator.entity.CollaboratorEntity;

@RunWith(SpringRunner.class)
public class CollaboratorTest {

	@Test
	public void shouldReturnCollaboratorEntity() {
		CollaboratorDTO dto = CollaboratorDTO.builder().firstname("Fname2").lastname("Lname2").email("email@test.com")
				.build();

		CollaboratorEntity entity = CollaboratorMapper.toEntity(dto);

		Assert.assertEquals(entity.getFirstname(), dto.getFirstname());
		Assert.assertEquals(entity.getLastname(), dto.getLastname());
		Assert.assertEquals(entity.getEmail(), dto.getEmail());

	}

	@Test
	public void shouldReturnCollaboratorDTO() {
		CollaboratorEntity entity = CollaboratorEntity.builder().id(1L).firstname("Fname2").lastname("Lname2")
				.email("email@test.com").createdAt(new Date()).updatedAt(new Date()).build();
		CollaboratorDTO dto = CollaboratorMapper.toDto(entity);

		Assert.assertEquals(entity.getFirstname(), dto.getFirstname());
		Assert.assertEquals(entity.getLastname(), dto.getLastname());
		Assert.assertEquals(entity.getEmail(), dto.getEmail());

	}

}
