package fr.esgi.registry.profile.service;

import fr.esgi.registry.common.ResourceNotFoundException;
import fr.esgi.registry.profile.dao.ProfileDao;
import fr.esgi.registry.profile.model.Profile;
import fr.esgi.registry.profile.model.ProfileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    private final ProfileDao profileDao;

    @Autowired
    public ProfileService(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    public List<Profile> findAll(){
        return profileDao.findAll();
    }

    public Profile findById(String id) {
        return profileDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("profile", "id", id));
    }

    public String save(ProfileDTO profileDTO) {
        Profile profile = new Profile(profileDTO.getFirstName(),
                profileDTO.getLastName(),
                profileDTO.getEmail(),
                profileDTO.getPassword(),
                profileDTO.getBirthDate());
        Profile addedProfile = profileDao.save(profile);

        return addedProfile.getId();
    }

    public void deleteById(String id) {
        Profile profile = findById(id);
        profileDao.deleteById(id);
    }
}
