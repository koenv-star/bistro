package be.multimedi.jammik.controllers;

import be.multimedi.jammik.entities.Zaak;
import be.multimedi.jammik.projections.ZakenPagina;
import be.multimedi.jammik.repositories.ZaakRepository;
import be.multimedi.jammik.services.ZaakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

/**
 * Made by Koen
 */
@RestController
@RequestMapping("/zaken")
@CrossOrigin
public class ZaakController {

    private ZaakService zaakService;

    private ZaakRepository repository;

    @Autowired
    public void setRepository(ZaakRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setZaakService(ZaakService zaakService) {
        this.zaakService = zaakService;
    }

    @GetMapping(value = "zaak/id={id}", produces = "application/json")
    public ResponseEntity<Zaak> getZaakById(@PathVariable("id") int id) {

        return repository.findById(id).map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Zaak>> getAlleZaken() {
        return ResponseEntity.ok(zaakService.getAlleZaken());
    }

    @GetMapping(value = "/display", produces = "application/json")
    public ResponseEntity<List<ZakenPagina>> getAlleZakenVoorDisplay() {
        return ResponseEntity.ok(repository.findAllBy(ZakenPagina.class));
    }

    @GetMapping(value = "{email}")
    public ResponseEntity<List<Zaak>> getZakenOpUitbater(@PathVariable("email") String email) {

        Optional<List<Zaak>> zaken = repository.findZaaksByEmail(email);

        return zaken.isPresent() ? ResponseEntity.ok(zaken.get()) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/display/{email}")
    public ResponseEntity<List<ZakenPagina>> getZakenOpUitbaterVoorDisplay(@PathVariable("email") String email) {
        return ResponseEntity.ok(repository.findAllByEmail(email));
    }

    @GetMapping(value = "zaak/{naam}", produces = "application/json")
    public ResponseEntity<Zaak> getZaakbyNaam(@PathVariable("naam") String zaaknaam) {

        return (repository.findZaakByNaam(zaaknaam).map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)));
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = "application/json")
    private ResponseEntity<Zaak> postHandler(@RequestParam("zaak") String zaakJsonString,
                                             @RequestParam("imageFile") MultipartFile file) throws Exception {

        Zaak zaak = zaakService.saveZaak(zaakJsonString, file);
        return zaak != null ? ResponseEntity.ok(zaak) : ResponseEntity.badRequest().build();
    }
}
