package be.multimedi.jammik.controllers;

import be.multimedi.jammik.services.KlantServiceImpl;
import be.multimedi.jammik.entities.Klant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return service.findAllEntities();
    }

    @PostMapping("register")
    public Klant save(@RequestBody Klant klant) {
        return service.saveEntity(klant);
    }
}