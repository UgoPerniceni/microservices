package fr.esgi.education.domain;

import java.util.List;
import java.util.Optional;

public interface CertificateDao {
    List<Certificate> findAll();

    Optional<Certificate> findById(String id);

    String save(Certificate certificate);

    void deleteById(String id);
}
