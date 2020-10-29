package be.multimedi.jammik.controllers;

import be.multimedi.jammik.entities.Menu;
import be.multimedi.jammik.exceptions.ExceptionHandling;
import be.multimedi.jammik.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Gemaakt door Jan
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends ExceptionHandling {

    private MenuRepository mr;

    @Autowired
    public MenuController(MenuRepository mr) {
        this.mr = mr;
    }

    @GetMapping(path="/{id:^\\d+$}", produces="application/json")
    public ResponseEntity<Menu> getByIdHandler(@PathVariable("id") int id) {
        if(id <= 0) return ResponseEntity.badRequest().build();

        Menu menu = mr.getMenuById(id);
        return menu != null ? ResponseEntity.ok(menu) : ResponseEntity.badRequest().build();
    }

    @GetMapping(produces="application/json")
    public ResponseEntity<List<Menu>> getAllHandler() {
        List<Menu> menus = mr.findAll();
        return ResponseEntity.ok(menus);
    }

    @PostMapping(consumes="application/json", produces="application/json")
    public ResponseEntity<Menu> postHandler(@RequestBody Menu menu) {

        if(menu == null || menu.getId() != 0)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(mr.save(menu));
    }

    @DeleteMapping(path="/{id:^\\d+$}")
    public ResponseEntity<?> deleteHandler(@PathVariable("id") int id) {
        if(id <= 0) return ResponseEntity.badRequest().build();

        mr.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
