package fr.esgi.auth.profile;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ProfileNotFoundException extends RuntimeException {

    private final Map<String, Object> errors;

    public ProfileNotFoundException() {
        this.errors = new HashMap<>();
        this.errors.put("resource", "profiles");
        log.error("No beer found with this username");
    }

    public Map<String, Object> getErrors() {
        return errors;
    }
}