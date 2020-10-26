package be.multimedi.jammik.controllers;

import be.multimedi.jammik.entities.Klant;
import be.multimedi.jammik.entities.Person;
import be.multimedi.jammik.services.GebruikerServiceImpl;
import be.multimedi.jammik.services.KlantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * made by Koen
 */
@RestController
@RequestMapping("Klanten")
@CrossOrigin()
public class KlantController {

    private KlantServiceImpl klantService;

    @Autowired
    public void setKlantService(KlantServiceImpl klantService) {
        this.klantService = klantService;
    }

    @PostMapping
    public void registerKlant(@RequestBody Klant klant) {
        klantService.saveKlant(klant);
    }
}

