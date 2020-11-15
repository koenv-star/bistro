package be.multimedi.jammik.controllers;

import be.multimedi.jammik.entities.Dag;
import be.multimedi.jammik.exceptions.ExceptionHandling;
import be.multimedi.jammik.repositories.DagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Gemaakt door Jan
 */
@RestController
@RequestMapping("/dag")
public class DagController extends ExceptionHandling {

    private DagRepository dr;

    @Autowired
    public DagController(DagRepository dr) {
        this.dr = dr;
    }


    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Dag>> getAllHandler() {
        List<Dag> dagen = dr.findAll();
        return ResponseEntity.ok(dagen);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Dag> postHandler(@RequestBody Dag dag) {

        if (dag == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(dr.save(dag));
    }
}
