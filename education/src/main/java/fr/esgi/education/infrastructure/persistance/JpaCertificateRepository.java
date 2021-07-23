package fr.esgi.education.infrastructure.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCertificateRepository extends JpaRepository<JpaCertificate, String> {}
