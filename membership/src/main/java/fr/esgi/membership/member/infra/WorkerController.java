package fr.esgi.membership.member.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workers")
public class WorkerController {

    private final WorkerRepository repository;

    @Autowired
    public WorkerController(WorkerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<WorkerProfileEntity>> get() {
         return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody WorkerProfileEntity entity) {
        repository.save(entity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
