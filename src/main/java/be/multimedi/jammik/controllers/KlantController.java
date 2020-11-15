package be.multimedi.jammik.controllers;

import be.multimedi.jammik.entities.Klant;
import be.multimedi.jammik.repositories.KlantRepository;
import be.multimedi.jammik.services.KlantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * made by Koen
 */

@RestController
@RequestMapping("klanten")
@CrossOrigin()
public class KlantController {

    private KlantServiceImpl klantService;

    private KlantRepository klantRepository;


    @Autowired
    public void setKlantService(KlantServiceImpl klantService) {
        this.klantService = klantService;
    }

    @Autowired

    public void setKlantRepository(KlantRepository klantRepository) {
        this.klantRepository = klantRepository;
    }


    @GetMapping()
    public List<Klant> getAll() {
        return klantRepository.findAll();
    }

    @GetMapping(path = "/{email}")
    public ResponseEntity<Klant> getKlantByEmail(@PathVariable("email") String email) {
        Optional<Klant> klant = klantRepository.findById(email);

        return klant.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping
    public ResponseEntity<Klant> save(@RequestBody Klant klant) {

        Klant klantrespons = klantService.saveKlant(klant);

        if (klantrespons != null) {
            return ResponseEntity.ok(klantrespons);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/{email}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Klant> putHandler(@PathVariable("email") String email, @RequestBody Klant klant) {
        Optional<Klant> tempKlant = klantRepository.findById(email);
        if (tempKlant.isPresent()) {
            Klant _tempklant = tempKlant.get();
            _tempklant.setNaam(klant.getNaam());
            _tempklant.setVoornaam(klant.getVoornaam());
            _tempklant.setReservaties(klant.getReservaties());
            _tempklant.setKrediet(klant.getKrediet());
            _tempklant.setBestellingVerzamelingen(klant.getBestellingVerzamelingen());
            System.out.println(tempKlant.toString());
            return new ResponseEntity<>(klantRepository.save(_tempklant), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

