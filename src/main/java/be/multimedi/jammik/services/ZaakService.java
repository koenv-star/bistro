package be.multimedi.jammik.services;

import be.multimedi.jammik.entities.Zaak;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Gemaakt door Jan
 */
public interface ZaakService {

    List<Zaak> getAlleZaken();

    ResponseEntity<Zaak> getZaakById(int id);

    Zaak saveZaak(String zaakJsonString, MultipartFile file) throws Exception;
}
