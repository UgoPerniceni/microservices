package fr.esgi.market.projects.infra;


import fr.esgi.market.common.ProjectMapper;
import fr.esgi.market.projects.domain.Project;
import fr.esgi.market.projects.domain.ProjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProjectEntityDao implements ProjectDao {

    private final ProjectMapper mapper;
    private final ProjectEntityRepository repository;

    @Autowired
    private ProjectEntityDao(ProjectMapper mapper, ProjectEntityRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public List<Project> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    public Optional<Project> findById(String id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    public List<Project> findAllBySkill(String skill) {
        return repository.findAll().stream().map(mapper::toDomain)
                .filter(m -> m.getSkills().contains(skill))
                .collect(Collectors.toList());
    }

    public String save(Project project) {
        ProjectEntity projectEntity = mapper.toEntity(project);
        repository.save(projectEntity);
        return projectEntity.getId();
    }
}
