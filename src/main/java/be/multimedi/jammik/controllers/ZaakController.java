package be.multimedi.jammik.controllers;

import be.multimedi.jammik.entities.Zaak;
import be.multimedi.jammik.repositories.ZaakRepository;
import be.multimedi.jammik.services.ZaakServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TextNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Made by Koen
 */
@RestController
@RequestMapping("zaken")
@CrossOrigin
public class ZaakController {

    private ZaakServiceImpl zaakService;

    private ZaakRepository repository;

    @Autowired
    public void setRepository(ZaakRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setZaakService(ZaakServiceImpl zaakService) {
        this.zaakService = zaakService;
    }

    @GetMapping
    public ResponseEntity<List<Zaak>> getAlleZaken() {

        return ResponseEntity.ok(zaakService.getAlleZaken());
    }

    @GetMapping(value = "{email}")
    public ResponseEntity<List<Zaak>> getZakenOpUitbater(@PathVariable("email") String email) {

        return ResponseEntity.ok(repository.findZaaksByUitbaterEmail(email).orElseThrow());
    }

    @GetMapping(value = "zaak/{naam}", produces="application/json")
    public ResponseEntity<Zaak> getZaakbyNaam(@PathVariable("naam") String zaaknaam) {

        return ResponseEntity.ok(repository.findZaakByNaam(zaaknaam).get());
    }

}
