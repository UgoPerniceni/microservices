package fr.esgi.registry.profile.dao;

import fr.esgi.registry.profile.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileDao extends JpaRepository<Profile, String> {

    List<Profile> findAll();

    Optional<Profile> findById(String id);

    Profile save(Profile profile);

    void deleteById(String id);
}
