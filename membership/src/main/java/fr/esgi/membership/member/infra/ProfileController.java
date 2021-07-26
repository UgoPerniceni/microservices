package fr.esgi.membership.member.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileRepository repository;

    @Autowired
    public ProfileController(ProfileRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<ProfileEntity>> get() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }
}
