package be.multimedi.jammik.controllers;

import be.multimedi.jammik.entities.Reservatie;
import be.multimedi.jammik.repositories.ReservatieRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Gemaakt door Jan
 */
@RestController
@RequestMapping("/reservatie")
public class ReservatieController {

    private ReservatieRepository rr;

    @Autowired
    public ReservatieController(ReservatieRepository rr) {
        this.rr = rr;
    }

    @GetMapping(path = "/{id:^\\d+$}", produces = "application/json")
    public ResponseEntity<Reservatie> getByIdHandler(@PathVariable("id") int id) {
        if (id <= 0) return ResponseEntity.badRequest().build();

        Reservatie reservatie = rr.getReservatieById(id);
        return reservatie != null ? ResponseEntity.ok(reservatie) : ResponseEntity.badRequest().build();
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Reservatie>> getAllHandler() {
        List<Reservatie> reservaties = rr.findAll();
        return ResponseEntity.ok(reservaties);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Reservatie> postHandler(@RequestBody Reservatie reservatie) {

        if (reservatie == null || reservatie.getId() != 0)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(rr.save(reservatie));
    }

    @DeleteMapping(path = "/{id:^\\d+$}")
    public ResponseEntity<?> deleteHandler(@PathVariable("id") int id) {
        if (id <= 0) return ResponseEntity.badRequest().build();

        rr.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "zaak/{id:^\\d+$}", produces = "application/json")
    public ResponseEntity<List<Reservatie>> getReservatiesByZaakId(@PathVariable("id") int id) {
        if (id <= 0) return ResponseEntity.badRequest().build();

        List<Reservatie> reservaties = rr.findReservatiesByZaak(id).orElse(new ArrayList<>());
        return ResponseEntity.ok(reservaties);
    }

}
