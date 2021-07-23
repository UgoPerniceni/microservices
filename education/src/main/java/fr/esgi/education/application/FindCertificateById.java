package fr.esgi.education.application;

import fr.esgi.common.exception.ResourceNotFoundException;
import fr.esgi.education.domain.Certificate;
import fr.esgi.education.domain.CertificateDao;
import org.springframework.stereotype.Service;

@Service
public class FindCertificateById {

    private final CertificateDao certificateDao;

    public FindCertificateById(CertificateDao certificateDao) {
        this.certificateDao = certificateDao;
    }

    public Certificate execute(String id) {
        return certificateDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("certificate", "id", id));
    }
}
