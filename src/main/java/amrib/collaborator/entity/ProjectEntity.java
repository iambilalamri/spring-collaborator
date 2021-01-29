package amrib.collaborator.entity;

import java.util.Date;

import javax.persistence.Entity;

import lombok.Data;

@Data
public class ProjectEntity {

	private Long id;
	private String name;
	private Date deadline;
	private String budget;
	private String sector;

}
