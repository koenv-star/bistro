package be.multimedi.jammik.services;

import be.multimedi.jammik.entities.Zaak;
import be.multimedi.jammik.repositories.ZaakRepository;
import be.multimedi.jammik.tools.ImageTool;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * made by Koen
 */
@Service
@Transactional
public class ZaakServiceImpl implements ZaakService {

    private ZaakRepository zaakRepository;
    private ImageTool imageTool;
    ObjectMapper mapper;

    public ZaakServiceImpl(ZaakRepository zaakRepository, ImageTool imageTool) {
        this.zaakRepository = zaakRepository;
        this.imageTool = imageTool;
        this.mapper = new ObjectMapper()
                .registerModule(new ParameterNamesModule())
                .registerModule(new JavaTimeModule());
    }

    public List<Zaak> getAlleZaken() {
        return zaakRepository.findAll();
    }

    public ResponseEntity<Zaak> getZaakById(int id) {
        return zaakRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public Zaak saveZaak(String zaakJsonString, MultipartFile file) throws Exception {

        String imageUrl;

        // convert json string to Zaak object
        Zaak zaak = mapper.readValue(zaakJsonString, Zaak.class);

        if (zaak == null || zaak.getId() != 0)
            return null;

        // put image in folder
        imageUrl = imageTool.putImageInFolder(file, zaak);

        // save the zaak to the database
        zaak.setImageURL(imageUrl);
        zaak = zaakRepository.save(zaak);

        // delete image if zaak not saved
        if (zaak.getId() == 0)
            imageTool.deleteImage(imageUrl);

        return zaak;
    }
}
