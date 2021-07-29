package fr.esgi.auth.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FindProfileByUsername {

    private final RestTemplate restTemplate;

    @Autowired
    public FindProfileByUsername(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.errorHandler(new RestTemplateResponseErrorHandler()).build();
    }

    public Profile execute(String username) {
        return restTemplate.getForObject("url/" + username, Profile.class);
    }
}
