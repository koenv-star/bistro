package be.multimedi.jammik.controllers;

import be.multimedi.jammik.entities.Reservatie;
import be.multimedi.jammik.repositories.ReservatieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        Optional<Reservatie> reservatie = rr.findById(id);
        return reservatie.isPresent()? ResponseEntity.ok(reservatie.get()) : ResponseEntity.badRequest().build();
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

    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Reservatie> putHandler(@RequestBody Reservatie reservatie) {
        Optional<Reservatie> reservatieData = rr.findById(reservatie.getId());

        if (reservatieData.isPresent()) {
            Reservatie _res = reservatieData.get();
            _res.setTijdstip(reservatie.getTijdstip());
            _res.setUurMarge(reservatie.getUurMarge());
            return new ResponseEntity<Reservatie>(rr.save(_res), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
