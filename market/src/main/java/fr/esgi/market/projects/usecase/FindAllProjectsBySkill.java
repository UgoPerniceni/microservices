package fr.esgi.market.projects.usecase;

import fr.esgi.market.projects.domain.Project;
import fr.esgi.market.projects.domain.ProjectDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllProjectsBySkill {

    private final ProjectDao projectDao;

    public FindAllProjectsBySkill(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public List<Project> execute(String skill) {
        return projectDao.findAllBySkill(skill);
    }
}
