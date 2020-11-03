package be.multimedi.jammik.controllers;

import be.multimedi.jammik.entities.Advertenties;
import be.multimedi.jammik.repositories.AdvertentiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author Mehmet van Team-B
 * */
@RestController
@RequestMapping("/Advertenties")
public class AdvertentiesController {


    private AdvertentiesRepository adr;

    @Autowired
    public AdvertentiesController(AdvertentiesRepository adr) {
        this.adr = adr;
    }

    @GetMapping
    public ResponseEntity<List<Advertenties>>  getAllAdvertenties(){
        return ResponseEntity.ok(adr.getAll());
    }

    @PostMapping(consumes="application/json", produces="application/json")
    public ResponseEntity<Advertenties> postHandler(@RequestBody Advertenties advertentie) {

        if(advertentie == null || advertentie.getId() != 0)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(adr.save(advertentie));
    }


}
