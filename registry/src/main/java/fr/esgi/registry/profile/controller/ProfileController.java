package fr.esgi.registry.profile.controller;

import fr.esgi.registry.profile.model.Profile;
import fr.esgi.registry.profile.model.ProfileDTO;
import fr.esgi.registry.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService){
        this.profileService = profileService;
    }

    @GetMapping
    public ResponseEntity<List<Profile>> findAll() {
        return new ResponseEntity<>(profileService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> findById(@PathVariable String id) {
        return new ResponseEntity<>(profileService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid ProfileDTO profileDTO) {
        String id = profileService.save(profileDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();

        return ResponseEntity.created(uri).build();
    }
}
