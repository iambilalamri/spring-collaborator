package amrib.collaborator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class CollaboratorDTO {
	
	private String firstname;
	private String lastname;
	private String email;
	

}
