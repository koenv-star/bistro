package be.multimedi.jammik.services;

import be.multimedi.jammik.entities.Zaak;
import be.multimedi.jammik.projections.ZakenPagina;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Gemaakt door Jan
 */
public interface ZaakService {

    List<Zaak> getAlleZaken();
    Zaak getZaakById(int id);
    Zaak saveZaak(String zaakJsonString, MultipartFile file) throws Exception;
}