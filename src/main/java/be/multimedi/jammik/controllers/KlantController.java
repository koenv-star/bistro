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
@RequestMapping("klanten")
@CrossOrigin()
public class KlantController {

    private KlantServiceImpl klantService;


    @Autowired
    public void setKlantService(KlantServiceImpl klantService) {
        this.klantService = klantService;
    }


    @GetMapping()
    public List<Klant> getAll() {
        return klantService.findAllKlanten();
    }

    @GetMapping(path = "/{email}")
    public Klant getKlantByEmail(@PathVariable("email") String email){
        return klantService.findKlantById(email);
    }
    @PostMapping
    public Klant save(@RequestBody Klant klant) {
        return klantService.saveKlant(klant);
    }
}

