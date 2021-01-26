package amrib.collaborator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CollaboratorDTO {
	
	private Long id;
	private String firstname;
	private String lastname;
	private String email;
	

}
