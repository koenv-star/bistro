package be.multimedi.jammik.controllers;

import be.multimedi.jammik.entities.Klant;
import be.multimedi.jammik.entities.Uitbater;
import be.multimedi.jammik.repositories.KlantRepository;
import be.multimedi.jammik.services.KlantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private KlantRepository klantRepository;



    @Autowired
    public void setKlantService(KlantServiceImpl klantService) {
        this.klantService = klantService;
    }

    @Autowired

    public void setKlantRepository(KlantRepository klantRepository) {this.klantRepository = klantRepository;}


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

    //Updating the Klant object
    @PutMapping(path = "/{email}" ,consumes = "application/json", produces = "application/json")
    public ResponseEntity<Klant> putHandler(@PathVariable ("email") String email, @RequestBody Klant klant){
        Klant tempKlant = klantService.findKlantById(email);
        if(tempKlant != null) {
            tempKlant.setNaam(klant.getNaam());
            tempKlant.setVoornaam(klant.getVoornaam());
            tempKlant.setReservaties(klant.getReservaties());
            tempKlant.setBestellingVerzamelingen(klant.getBestellingVerzamelingen());
            tempKlant.setKrediet(klant.getKrediet());
            System.out.println(tempKlant.toString());
            return new ResponseEntity<>(klantRepository.save(tempKlant), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

