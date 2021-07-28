package fr.esgi.market.projects.usecase;

import fr.esgi.market.projects.domain.Project;
import fr.esgi.market.projects.domain.ProjectDao;
import org.springframework.stereotype.Service;

@Service
public class AddProject {

    private final ProjectDao projectDao;

    public AddProject(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public String execute(Project project) {
        return projectDao.save(project);
    }
}
