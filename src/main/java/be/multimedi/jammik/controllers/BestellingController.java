package be.multimedi.jammik.controllers;

import be.multimedi.jammik.entities.Bestelling;
import be.multimedi.jammik.exceptions.ExceptionHandling;
import be.multimedi.jammik.repositories.BestellingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Gemaakt door Jan
 */
@RestController
@RequestMapping("/bestelling")
public class BestellingController extends ExceptionHandling {

    private BestellingRepository br;

    @Autowired
    public BestellingController(BestellingRepository br) {
        this.br = br;
    }

    @GetMapping(path="/{id:^\\d+$}", produces="application/json")
    public ResponseEntity<Bestelling> getByIdHandler(@PathVariable("id") int id) {
        if(id <= 0) return ResponseEntity.badRequest().build();

        Bestelling bestelling = br.getBestellingById(id);
        return bestelling != null ? ResponseEntity.ok(bestelling) : ResponseEntity.badRequest().build();
    }

    @GetMapping(produces="application/json")
    public ResponseEntity<List<Bestelling>> getAllHandler() {
        List<Bestelling> bestellingen = br.findAll();
        return ResponseEntity.ok(bestellingen);
    }

    @PostMapping(consumes="application/json", produces="application/json")
    public ResponseEntity<Bestelling> postHandler(@RequestBody Bestelling bestelling) {

        if(bestelling == null || bestelling.getId() == 0)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(br.save(bestelling));
    }

    @DeleteMapping(path="/{id:^\\d+$}")
    public ResponseEntity<?> deleteHandler(@PathVariable("id") int id) {
        if(id <= 0) return ResponseEntity.badRequest().build();

        br.deleteById(id);
        return ResponseEntity.ok().build();
    }
}