package be.multimedi.jammik.controllers;


import be.multimedi.jammik.entities.Klant;
import be.multimedi.jammik.services.GebruikerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * made by Koen
 */

@RestController
@RequestMapping("gebruiker")
@CrossOrigin()
public class GebruikerController {

    private GebruikerServiceImpl service;


    @Autowired
    public void setService(GebruikerServiceImpl service) {
        this.service = service;
    }

    @GetMapping()
    public Klant getHuidigeGebruiker() {

        System.out.println(service.getPerson().getNaam());
        return service.getPerson();
    }


    }

