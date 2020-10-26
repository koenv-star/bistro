package be.multimedi.jammik.controllers;

import be.multimedi.jammik.entities.MenuItem;
import be.multimedi.jammik.exceptions.ExceptionHandling;
import be.multimedi.jammik.repositories.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menuitem")
public class MenuItemController extends ExceptionHandling {

    private MenuItemRepository mir;

    @Autowired
    public MenuItemController(MenuItemRepository mir) {
        this.mir = mir;
    }

    @GetMapping(path="/{id:^\\d+$}", produces="application/json")
    public ResponseEntity<MenuItem> getByIdHandler(@PathVariable("id") int id) {
        if(id <= 0) return ResponseEntity.badRequest().build();

        MenuItem menuItem = mir.getMenuItemById(id);
        return menuItem != null ? ResponseEntity.ok(menuItem) : ResponseEntity.badRequest().build();
    }

    @GetMapping(produces="application/json")
    public ResponseEntity<List<MenuItem>> getAllHandler() {
        List<MenuItem> menuItems = mir.findAll();
        return ResponseEntity.ok(menuItems);
    }

    @PostMapping(consumes="applciation/json", produces="application/json")
    public ResponseEntity<MenuItem> postHandler(@RequestBody MenuItem menuItem) {

        if(menuItem == null || menuItem.getId() != 0)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(mir.save(menuItem));
    }

    @DeleteMapping(path="/{id:^\\d+$}")
    public ResponseEntity<?> deleteHandler(@PathVariable("id") int id) {
        if(id <= 0) return ResponseEntity.badRequest().build();

        mir.deleteById(id);
        return ResponseEntity.ok().build();
    }
}