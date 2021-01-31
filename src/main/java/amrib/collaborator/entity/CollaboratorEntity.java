package amrib.collaborator.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "COLLABORATORS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CollaboratorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name")
	@NotBlank(message = "Firstname is mondatory")
	private String firstname;

	@Column(name = "last_name")
	@NotBlank(message = "Lastname is mondatory")
	private String lastname;

	@Column(name = "email")
	@NotBlank(message = "The email should not be blank")
	@Email(message = "The email is invalid")
	private String email;

	@CreationTimestamp
	private Date createdAt;

	@UpdateTimestamp
	private Date updatedAt;

	public CollaboratorEntity(String firstname, String lastname, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

}
