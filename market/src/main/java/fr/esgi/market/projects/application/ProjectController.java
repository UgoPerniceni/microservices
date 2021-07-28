package fr.esgi.market.projects.application;

import fr.esgi.market.projects.domain.Project;
import fr.esgi.market.projects.usecase.AddProject;
import fr.esgi.market.projects.usecase.FindAllProjects;
import fr.esgi.market.projects.usecase.FindAllProjectsBySkill;
import fr.esgi.market.projects.usecase.FindProjectById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/projects")
@RestController
public class ProjectController {

    private final AddProject addProject;
    private final FindAllProjects findAllProjects;
    private final FindAllProjectsBySkill findAllProjectsBySkill;
    private final FindProjectById findProjectById;

    @Autowired
    public ProjectController(AddProject addProject,
                             FindAllProjects findAllProjects,
                             FindAllProjectsBySkill findAllProjectsBySkill,
                             FindProjectById findProjectById) {
        this.addProject = addProject;
        this.findAllProjects = findAllProjects;
        this.findAllProjectsBySkill = findAllProjectsBySkill;
        this.findProjectById = findProjectById;
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAll() {
        return new ResponseEntity<>(findAllProjects.execute(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getById(@PathVariable String id) {
        return new ResponseEntity<>(findProjectById.execute(id), HttpStatus.OK);
    }

    @GetMapping("/skills/{skill}")
    public ResponseEntity<List<Project>> getBySkill(@PathVariable String skill) {
        return new ResponseEntity<>(findAllProjectsBySkill.execute(skill), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Project project) {
        String id = addProject.execute(project);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }
}
