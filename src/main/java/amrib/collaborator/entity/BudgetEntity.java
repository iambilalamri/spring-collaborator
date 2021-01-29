package amrib.collaborator.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BudgetEntity {

	private Long id;
	private String type;
	private String value;
	private String description;
}
