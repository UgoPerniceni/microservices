package fr.esgi.education.infrastructure;

import fr.esgi.education.application.AddCertificate;
import fr.esgi.education.application.DeleteCertificateById;
import fr.esgi.education.application.FindAllCertificates;
import fr.esgi.education.application.FindCertificateById;
import fr.esgi.education.domain.Certificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/certificates")
public class CertificateController {

    private final FindAllCertificates findAllCertificates;
    private final FindCertificateById findCertificateById;
    private final AddCertificate addCertificate;
    private final DeleteCertificateById deleteCertificateById;

    @Autowired
    public CertificateController(FindAllCertificates findAllCertificates,
                                 FindCertificateById findCertificateById,
                                 AddCertificate addCertificate,
                                 DeleteCertificateById deleteCertificateById) {
        this.findAllCertificates = findAllCertificates;
        this.findCertificateById = findCertificateById;
        this.addCertificate = addCertificate;
        this.deleteCertificateById = deleteCertificateById;
    }

    @GetMapping
    public ResponseEntity<List<Certificate>> findAll() {
        return new ResponseEntity<>(findAllCertificates.execute(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Certificate> findById(@PathVariable String id) {
        return new ResponseEntity<>(findCertificateById.execute(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Certificate certificate) {
        String id = addCertificate.execute(certificate);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        deleteCertificateById.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
