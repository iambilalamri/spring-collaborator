package amrib.collaborator.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
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

@RestController
@RequestMapping("/api/v1")
public class CollaboratorController {

	@Autowired
	private CollaboratorRepository collaboratorRepository;

	@GetMapping(value = "/collaborator")
	public List<CollaboratorEntity> getCollaborators() {
		return collaboratorRepository.findAll();
	}

	@GetMapping(value = "/collaborator/{id}")
	@Cacheable("collaborator")
	public CollaboratorDTO getCollaborator(@PathVariable(value = "id") long id) {

		CollaboratorEntity entity = collaboratorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Collaborator not found with id =" + id));
		System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
		try {
			// To check if the @Cacheable decorator works
			Thread.sleep(1000 * 5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CollaboratorMapper.toDto(entity);
	}

	@PostMapping(value = "/collaborator")
	public CollaboratorEntity createCollaborator(@Valid @RequestBody CollaboratorEntity collaborator) {
		if (collaborator == null)
			return null;
		return collaboratorRepository.save(collaborator);

	}

	@PutMapping(value = "/collaborator/{id}")
	public CollaboratorEntity updateCollaborator(@Valid @RequestBody CollaboratorEntity collaborator,
			@PathVariable("id") long id) {
		return collaboratorRepository.findById(id).map(existing -> {
			existing.setFirstname(collaborator.getFirstname());
			existing.setLastname(collaborator.getLastname());
			existing.setEmail(collaborator.getEmail());
			return this.collaboratorRepository.save(existing);
		}).orElseThrow(() -> new ResourceNotFoundException("Collaborator not found with id = " + id));

	}

	@DeleteMapping(value = "/collaborator/{id}")
	public ResponseEntity<CollaboratorEntity> deleteCollaborator(@PathVariable(value = "id") long id) {

		CollaboratorEntity existing = collaboratorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Collaborator not found with id = " + id));
		this.collaboratorRepository.delete(existing);
		return ResponseEntity.ok().build();
	}

}
