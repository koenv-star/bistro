package be.multimedi.jammik.controllers;


import be.multimedi.jammik.common.Gebruiker;
import be.multimedi.jammik.entities.Uitbater;
import be.multimedi.jammik.repositories.UitbaterRepository;
import be.multimedi.jammik.services.UitbaterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;
import java.util.List;
import java.util.Optional;

/**
 * Made by Koennnn
 */


@RestController
@RequestMapping("uitbaters")
@CrossOrigin()
public class UitbaterController {

    private UitbaterServiceImpl uitbaterService;

    private UitbaterRepository repository;

    @Autowired
    public void setRepository(UitbaterRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setUitbaterService(UitbaterServiceImpl uitbaterService) {
        this.uitbaterService = uitbaterService;
    }


    @GetMapping()
    public List<Uitbater> getAll(){  return  uitbaterService.findAllUitbaters();}


//    @GetMapping()
//    public List<Uitbater> getAll() {
//        return repository.findAll();
//    }

    @GetMapping(path = "/{email}")
    public Uitbater getUitbaterByEmail(@PathVariable("email") String email ){
        return uitbaterService.findUitbaterByEmail(email);

    }


    @PostMapping
    public Uitbater registerUitbater(@RequestBody Uitbater uitbater) {
        return this.uitbaterService.saveUitbater(uitbater);
    }

    //Updating the Uitbater object
    @PutMapping(path = "/{email}" ,consumes = "application/json", produces = "application/json")
    public ResponseEntity<Uitbater> putHandler(@PathVariable ("email") String email, @RequestBody Uitbater uitbater){
        Uitbater tempUitbater = uitbaterService.findUitbaterByEmail(email);
        if(tempUitbater != null) {
            tempUitbater.setNaam(uitbater.getNaam());
            tempUitbater.setVoornaam(uitbater.getVoornaam());
            tempUitbater.setReservaties(uitbater.getReservaties());
            tempUitbater.setZaken(uitbater.getZaken());
            tempUitbater.setBestellingVerzamelingen(uitbater.getBestellingVerzamelingen());
            tempUitbater.setKrediet(uitbater.getKrediet());
            return new ResponseEntity<>(repository.save(tempUitbater), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

}
