package be.multimedi.jammik.klant;


import be.multimedi.jammik.Service.KlantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("klanten")
@CrossOrigin()
public class KlantController {

    private KlantServiceImpl service;

    @Autowired
    public void setService(KlantServiceImpl service) {
        this.service = service;
    }


    @PostMapping()
    public Klant save(@RequestBody Klant klant) {
        return service.saveEntity(klant);
    }

    @GetMapping()
    List<Klant> getAll() {
        return service.findAllEntities();

    }

}
