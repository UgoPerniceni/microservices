package fr.esgi.market.projects.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectEntityRepository extends JpaRepository<ProjectEntity, String> {
}
