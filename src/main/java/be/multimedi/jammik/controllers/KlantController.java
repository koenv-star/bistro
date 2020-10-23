package be.multimedi.jammik.controllers;


import be.multimedi.jammik.services.KlantServiceImpl;
import be.multimedi.jammik.entities.Klant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("klanten")
@CrossOrigin()
public class KlantController {

    private KlantServiceImpl service;

    @Autowired
    public void setService(KlantServiceImpl service) {
        this.service = service;
    }


    @PostMapping("register")
    public Klant save(@RequestBody Klant klant) {
        return service.saveEntity(klant);
    }

    @GetMapping()
    List<Klant> getAll() {
        return service.findAllEntities();

    }

}
