package amrib.collaborator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "GRADE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "grade_name")
	@NotBlank(message = "The grade name is mondatory")
	private String name;

	@Column(name = "grade_salary")
	@Min(value = 1500, message = "the salary is invalid")
	private double salary;

}
