package fr.esgi.market.projects.domain;

import java.util.List;
import java.util.Optional;

public interface ProjectDao {

    List<Project> findAll();

    Optional<Project> findById(String id);

    String save(Project project);

    List<Project> findAllBySkill(String skill);
}
