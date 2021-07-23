package fr.esgi.education.application;

import fr.esgi.education.domain.Certificate;
import fr.esgi.education.domain.CertificateDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllCertificates {
    private final CertificateDao certificateDao;

    public FindAllCertificates(CertificateDao certificateDao) {
        this.certificateDao = certificateDao;
    }

    public List<Certificate> execute() {
        return certificateDao.findAll();
    }
}
