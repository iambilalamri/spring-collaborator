package amrib.collaborator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import amrib.collaborator.entity.CollaboratorEntity;

@RepositoryRestResource
public interface CollaboratorRepository extends JpaRepository<CollaboratorEntity, Long> {

}
