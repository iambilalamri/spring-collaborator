package amrib.collaborator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import amrib.collaborator.entity.GradeEntity;

@RepositoryRestResource
public interface GradeRepository extends JpaRepository<GradeEntity, Long> {

}
