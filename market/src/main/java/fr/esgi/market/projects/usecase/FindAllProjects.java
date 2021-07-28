package fr.esgi.market.projects.usecase;

import fr.esgi.market.projects.domain.Project;
import fr.esgi.market.projects.domain.ProjectDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllProjects {

    private final ProjectDao projectDao;

    public FindAllProjects(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public List<Project> execute() {
        return this.projectDao.findAll();
    }
}
