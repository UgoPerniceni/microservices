package fr.esgi.education.infrastructure.persistance;

import fr.esgi.education.domain.Certificate;
import fr.esgi.education.domain.CertificateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaCertificateDao implements CertificateDao {

    private final JpaCertificateRepository repository;

    @Autowired
    public JpaCertificateDao(JpaCertificateRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Certificate> findAll() {
        return repository.findAll()
                .stream()
                .map(jpaCertificate -> new Certificate(jpaCertificate.getId(), jpaCertificate.getName(), jpaCertificate.getCreatedAt()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Certificate> findById(String id) {
        Optional<JpaCertificate> jpaCertificate = repository.findById(id);
        return jpaCertificate.map(certificate -> new Certificate(certificate.getId(), certificate.getName(), certificate.getCreatedAt()));
    }

    @Override
    public String save(Certificate certificate) {
        JpaCertificate jpaCertificate = new JpaCertificate(certificate.getId(), certificate.getName(), certificate.getCreatedAt());
        repository.save(jpaCertificate);
        return jpaCertificate.getId();
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
