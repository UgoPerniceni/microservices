package fr.esgi.education.application;

import fr.esgi.education.domain.Certificate;
import fr.esgi.education.domain.CertificateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddCertificate {

    private final CertificateDao certificateDao;

    @Autowired
    public AddCertificate(CertificateDao certificateDao) {
        this.certificateDao = certificateDao;
    }

    public String execute(Certificate certificate) {
        return certificateDao.save(certificate);
    }
}
