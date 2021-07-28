package fr.esgi.market.projects.usecase;

import fr.esgi.market.projects.domain.Project;
import fr.esgi.market.projects.domain.ProjectDao;
import org.springframework.stereotype.Service;

@Service
public class FindProjectById {

    private final ProjectDao projectDao;

    public FindProjectById(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public Project execute(String id) {
        return projectDao.findById(id).orElse(null);
    }
}
