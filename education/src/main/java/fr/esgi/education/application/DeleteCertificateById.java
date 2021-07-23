package fr.esgi.education.application;

import fr.esgi.education.domain.CertificateDao;
import org.springframework.stereotype.Service;

@Service
public class DeleteCertificateById {
    private final CertificateDao certificateDao;
    private final FindCertificateById findCertificateById;

    public DeleteCertificateById(CertificateDao certificateDao, FindCertificateById findCertificateById) {
        this.certificateDao = certificateDao;
        this.findCertificateById = findCertificateById;
    }

    public void execute(String id) {
        findCertificateById.execute(id);
        certificateDao.deleteById(id);
    }
}
