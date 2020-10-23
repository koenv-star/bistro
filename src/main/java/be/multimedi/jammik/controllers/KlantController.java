package be.multimedi.jammik.controllers;

import be.multimedi.jammik.entities.Klant;
import be.multimedi.jammik.services.KlantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * made by Koen
 */

@RestController
@RequestMapping("/klant")
public class KlantController {

    private KlantServiceImpl service;

    @Autowired
    public KlantController(KlantServiceImpl service) {
        this.service = service;
    }

    @GetMapping()
    List<Klant> findAll() {
        return service.findAllKlanten();
    }

    @PostMapping("register")
    public Klant save(@RequestBody Klant klant) {
        return service.saveKlant(klant);
    }
}