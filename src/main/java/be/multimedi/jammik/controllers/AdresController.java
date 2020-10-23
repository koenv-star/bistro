package be.multimedi.jammik.controllers;

import be.multimedi.jammik.entities.Adres;
import be.multimedi.jammik.exceptions.ExceptionHandling;
import be.multimedi.jammik.repositories.AdresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Gemaakt door Jan
 */
@RestController
@RequestMapping("/adres")
public class AdresController extends ExceptionHandling {

    private AdresRepository ar;

    @Autowired
    public AdresController(AdresRepository ar) {
        this.ar = ar;
    }

    @GetMapping(path="/{id:^\\d+$}", produces="application/json")
    public ResponseEntity<Adres> getByIdHandler(@PathVariable("id") int id) {
        if(id <= 0) return ResponseEntity.badRequest().build();

        Adres adres = ar.getAdresById(id);
        return adres != null ? ResponseEntity.ok(adres) : ResponseEntity.badRequest().build();
    }

    @GetMapping(produces="application/json")
    public ResponseEntity<List<Adres>> getAllHandler() {
        List<Adres> addressen = ar.findAll();
        return ResponseEntity.ok(addressen);
    }

    @PostMapping(consumes="application/json", produces="application/json")
    public ResponseEntity<Adres> postHandler(@RequestBody Adres adres) {

        if(adres == null || adres.getId() != 0)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(ar.save(adres));
    }

    @DeleteMapping(path="/{id:^\\d+$}")
    public ResponseEntity<?> deleteHandler(@PathVariable("id") int id) {
        if(id <= 0) return ResponseEntity.badRequest().build();

        ar.deleteById(id);
        return ResponseEntity.ok().build();
    }
}