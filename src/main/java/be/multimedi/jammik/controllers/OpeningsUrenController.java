package be.multimedi.jammik.controllers;

import be.multimedi.jammik.entities.OpeningsUren;
import be.multimedi.jammik.exceptions.ExceptionHandling;
import be.multimedi.jammik.repositories.OpeningsUrenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Gemaakt door Jan
 */
@RestController
@RequestMapping("/openingsuur")
public class OpeningsUrenController extends ExceptionHandling {

    private OpeningsUrenRepository our;

    @Autowired
    public OpeningsUrenController(OpeningsUrenRepository our) {
        this.our = our;
    }

    @GetMapping(path="/{id:^\\d+$}}", produces="application/json")
    public ResponseEntity<OpeningsUren> getByIdHandler(@PathVariable("id") int id) {
        if(id <= 0) return ResponseEntity.badRequest().build();

        OpeningsUren ou = our.getOpeningsUrenById(id);
        return ou != null ? ResponseEntity.ok(ou) : ResponseEntity.badRequest().build();
    }

    @GetMapping(produces="application/json")
    public ResponseEntity<List<OpeningsUren>> getAllHandler() {
        List<OpeningsUren> ourn = our.findAll();
        return ResponseEntity.ok(ourn);
    }

    @PostMapping(consumes="application/json", produces="application/json")
    public ResponseEntity<OpeningsUren> postHandler(@RequestBody OpeningsUren ou) {

        if(ou == null || ou.getId() != 0)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(our.save(ou));
    }

    @DeleteMapping(path="/{id:^\\d+$}")
    public ResponseEntity<?> deleteHandler(@PathVariable("id") int id) {
        if(id <= 0) return ResponseEntity.badRequest().build();

        our.deleteById(id);
        return ResponseEntity.ok().build();
    }
}