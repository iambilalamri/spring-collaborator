package amrib.collaborator.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import amrib.collaborator.dto.CollaboratorDTO;
import amrib.collaborator.entity.CollaboratorEntity;
import amrib.collaborator.exception.ResourceNotFoundException;
import amrib.collaborator.mapping.CollaboratorMapper;
import amrib.collaborator.repository.CollaboratorRepository;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/v1")
public class CollaboratorController {

	@Autowired
	private CollaboratorRepository collaboratorRepository;
	@Autowired
	private CollaboratorMapper collaboratorMapper;

	@GetMapping(value = "/collaborator")
	public List<CollaboratorEntity> getCollaborators() {
		return collaboratorRepository.findAll();
	}

	@GetMapping(value = "/collaborator/{id}")
	public CollaboratorDTO getCollaborator(@PathVariable(value = "id") long id) {
		CollaboratorEntity entity = collaboratorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Collaborator not found with id =" + id));

		// return collaboratorMapper.toDto(entity);
		return collaboratorMapper.toDto(entity);
	}

	@PostMapping(value = "/collaborator")
	public CollaboratorEntity createCollaborator(@Valid @RequestBody CollaboratorEntity collaborator) {
		return collaboratorRepository.save(collaborator);
	}

	@PutMapping(value = "/collaborator/{id}")
	public CollaboratorEntity updateCollaborator(@Valid @RequestBody CollaboratorEntity collaborator,
			@PathVariable("id") long id) {
		CollaboratorEntity existing = collaboratorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Collaborator not found with id = " + id));
		existing.setFirstname(collaborator.getFirstname());
		existing.setLastname(collaborator.getLastname());
		existing.setEmail(collaborator.getEmail());
		return this.collaboratorRepository.save(existing);
	}

	@DeleteMapping(value = "/collaborator/{id}")
	public ResponseEntity<CollaboratorEntity> deleteCollaborator(@PathVariable(value = "id") long id) {

		CollaboratorEntity existing = collaboratorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Collaborator not found with id = " + id));
		this.collaboratorRepository.delete(existing);
		return ResponseEntity.ok().build();
	}

}
