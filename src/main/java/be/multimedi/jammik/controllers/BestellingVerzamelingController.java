package be.multimedi.jammik.controllers;

import be.multimedi.jammik.entities.BestellingVerzameling;
import be.multimedi.jammik.exceptions.ExceptionHandling;
import be.multimedi.jammik.repositories.BestellingVerzamelingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Gemaakt door Jan
 */
@RestController
@RequestMapping("/bestellingVerzameling")
public class BestellingVerzamelingController extends ExceptionHandling {

    private BestellingVerzamelingRepository bvr;

    @Autowired
    public BestellingVerzamelingController(BestellingVerzamelingRepository bvr) {
        this.bvr = bvr;
    }

    @GetMapping(path = "/{id:^\\d+$}", produces = "application/json")
    public ResponseEntity<BestellingVerzameling> getByIdHandler(@PathVariable("id") int id) {
        if (id <= 0) return ResponseEntity.badRequest().build();

        Optional<BestellingVerzameling> bv = bvr.findById(id);
        return bv.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping(path = "/email={email}", produces = "application/json")
    public ResponseEntity<List<BestellingVerzameling>> getByIdHandler(@PathVariable("email") String email) {
        if (email.isBlank()) return ResponseEntity.badRequest().build();

        List<BestellingVerzameling> bv = bvr.findAllByKlant(email);
        return bv != null ? ResponseEntity.ok(bv) : ResponseEntity.badRequest().build();
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<BestellingVerzameling>> getAllHandler() {
        List<BestellingVerzameling> bvn = bvr.findAll();
        return ResponseEntity.ok(bvn);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<BestellingVerzameling> postHandler(@RequestBody BestellingVerzameling bv) {

        if (bv == null || bv.getId() != 0)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(bvr.save(bv));
    }

    @DeleteMapping(path = "/{id:^\\d+$}")
    public ResponseEntity<?> deleteMapping(@PathVariable("id") int id) {
        if (id <= 0) return ResponseEntity.badRequest().build();

        bvr.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
