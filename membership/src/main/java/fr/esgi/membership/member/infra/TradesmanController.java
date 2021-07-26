package fr.esgi.membership.member.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tradesmen")
public class TradesmanController {

    private final TradesmanRepository repository;

    @Autowired
    public TradesmanController(TradesmanRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<TradesmanProfileEntity>> get(){
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody TradesmanProfileEntity tradesman) {
        repository.save(tradesman);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
