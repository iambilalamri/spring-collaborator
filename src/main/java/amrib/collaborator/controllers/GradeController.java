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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import amrib.collaborator.entity.GradeEntity;
import amrib.collaborator.exception.ResourceNotFoundException;
import amrib.collaborator.repository.GradeRepository;

@RestController
@RequestMapping("/api/v1")
public class GradeController {

	@Autowired
	private GradeRepository gradeRepository;

	@GetMapping(value = "/grade")
	public List<GradeEntity> getGrades() {
		return gradeRepository.findAll();
	}

	@GetMapping(value = "/grade/{id}")
	public ResponseEntity<GradeEntity> getGrade(@PathVariable(value = "id") long id) {
		GradeEntity grade = gradeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Grade not found with id = " + id));
		return ResponseEntity.ok(grade);
	}

	@GetMapping(value = "/grade/findBy")
	public ResponseEntity<GradeEntity> getGradeByName(@RequestParam(name = "name") String name) {
		GradeEntity grade = gradeRepository.findGradeByName(name)
				.orElseThrow(() -> new ResourceNotFoundException("Grade not found with name = " + name));
		return ResponseEntity.ok(grade);
	}

	@PostMapping(value = "/grade")
	public GradeEntity createGrade(@Valid @RequestBody GradeEntity grade) {
		return gradeRepository.save(grade);
	}

	@PutMapping(value = "/grade/{id}")
	public GradeEntity updateGrade(@RequestBody GradeEntity grade, @PathVariable("id") long id) {
		return gradeRepository.findById(id).map(existing -> {
			existing.setName(grade.getName());
			existing.setSalary(grade.getSalary());
			return this.gradeRepository.save(existing);
		}).orElseThrow(() -> new ResourceNotFoundException("Grade not found with id = " + id));
	}

	@DeleteMapping(value = "/grade/{id}")
	public ResponseEntity<GradeEntity> deleteGrade(@PathVariable(value = "id") long id) {

		GradeEntity existing = gradeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Grade not found with id" + id));
		this.gradeRepository.delete(existing);
		return ResponseEntity.ok().build();
	}

}
