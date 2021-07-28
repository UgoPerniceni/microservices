package fr.esgi.market.common;

import fr.esgi.market.projects.domain.Project;
import fr.esgi.market.projects.infra.ProjectEntity;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper implements Mapper<Project, ProjectEntity> {

    @Override
    public Project toDomain(ProjectEntity entity) {
        return new Project(entity.getId(),
                entity.getStart(),
                entity.getEnd(),
                entity.getSkills()
        );
    }

    @Override
    public ProjectEntity toEntity(Project object) {
        return new ProjectEntity(object.getId(),
                object.getStart(),
                object.getEnd(),
                object.getSkills());
    }
}
