package be.multimedi.jammik.controllers;

import be.multimedi.jammik.entities.Zaak;
import be.multimedi.jammik.services.ZaakServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Made by Koen
 */
@RestController
@RequestMapping("zaken")
@CrossOrigin
public class ZaakController {

    private ZaakServiceImpl zaakService;

    @Autowired
    public void setZaakService(ZaakServiceImpl zaakService) {
        this.zaakService = zaakService;
    }

    @GetMapping
    public ResponseEntity<List<Zaak>>  getAlleZaken() {

        return ResponseEntity.ok(zaakService.getAlleZaken()) ;
    }

    @PostMapping
    public String getZakenOpUitbater(@RequestBody() String email) {
        return zaakService.getZakenOpUitbater(email).get(0).getNaam();
    }


}
