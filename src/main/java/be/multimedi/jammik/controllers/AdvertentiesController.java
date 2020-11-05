package be.multimedi.jammik.controllers;

import be.multimedi.jammik.entities.Advertenties;
import be.multimedi.jammik.entities.Uitbater;
import be.multimedi.jammik.repositories.AdvertentiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mehmet van Team-B
 */
@RestController
@RequestMapping("/advertenties")
public class AdvertentiesController {


    private AdvertentiesRepository adr;

    @Autowired
    public AdvertentiesController(AdvertentiesRepository adr) {
        this.adr = adr;
    }

    @GetMapping
    public ResponseEntity<List<Advertenties>> getAllAdvertenties() {
        return ResponseEntity.ok(adr.getAll());

    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Advertenties> postHandler(@RequestBody Advertenties advertentie) {

        if (advertentie == null || advertentie.getId() != 0)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(adr.save(advertentie));
    }

    //Updating the Advertentie object
    @PutMapping(path = "/{id:^\\d+$}" ,consumes = "application/json", produces = "application/json")
    public ResponseEntity<Advertenties> putHandler(@PathVariable ("id") int id, @RequestBody Advertenties advertentie){
        Advertenties tempAdvertentie = adr.getAdvertentiesById(id);
        if(tempAdvertentie != null) {
            tempAdvertentie.setNumberOfShow(advertentie.getNumberOfShow());
            tempAdvertentie.setZaakDesc(advertentie.getZaakDesc());
            tempAdvertentie.setZaakId(advertentie.getZaakId());
            tempAdvertentie.setZaakNaam(advertentie.getZaakNaam());
            return new ResponseEntity<>(adr.save(tempAdvertentie), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }



    @DeleteMapping(path = "/{id:^\\d+$}")
    public ResponseEntity<?> deleteHandler(@PathVariable("id") int id) {
        if (id <= 0) return ResponseEntity.badRequest().build();

        adr.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
