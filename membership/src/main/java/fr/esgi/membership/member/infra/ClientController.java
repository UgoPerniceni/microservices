package fr.esgi.membership.member.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/clients")
@RestController
public class ClientController {

    private final ClientRepository repository;

    @Autowired
    public ClientController(ClientRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<ClientProfileEntity>> get() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody ClientProfileEntity entity) {
        repository.save(entity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
