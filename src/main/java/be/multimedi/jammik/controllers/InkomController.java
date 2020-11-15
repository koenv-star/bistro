package be.multimedi.jammik.controllers;


import be.multimedi.jammik.entities.Bestelling;
import be.multimedi.jammik.entities.Inkom;
import be.multimedi.jammik.entities.Zaak;
import be.multimedi.jammik.repositories.BestellingRepository;
import be.multimedi.jammik.repositories.UitbaterRepository;
import be.multimedi.jammik.repositories.ZaakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * @author Mehmet van Team-B
 */
@RestController
@RequestMapping("/inkoms")
public class InkomController {


    private BestellingRepository br;
    private ZaakRepository zr;
    private UitbaterRepository ur;


    @Autowired
    public InkomController(BestellingRepository br, ZaakRepository zr, UitbaterRepository ur) {
        this.br = br;
        this.zr = zr;
        this.ur = ur;

    }

    @GetMapping("/{email}")
    public ResponseEntity<List<Inkom>> getAllHandler(@PathVariable("email") String email) {
        List<Inkom> inkomList = new ArrayList<>();
        List<Zaak> zaken = ur.getOne(email).getZaken();

        for (Zaak zaak : zaken) {
            Inkom inkom = this.getbyId(zaak.getId());
            inkomList.add(Objects.requireNonNullElseGet(inkom, () -> new Inkom(zaak.getId(), zaak.getNaam(), 0)));
        }
        if (inkomList != null) {
            return ResponseEntity.ok(inkomList);

        } else {
            return ResponseEntity.badRequest().build();
        }


    }

    @GetMapping("/id/{id:^\\d+$}")
    public ResponseEntity<Inkom> getInkomsById(@PathVariable("id") int id) {
        Inkom inkom = this.getbyId(id);
        if (inkom != null) {
            return ResponseEntity.ok(inkom);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    //getting inkom object according to zaak id
    public Inkom getbyId(int id) {
        List<Bestelling> bestellingen = br.findAll();
        bestellingen = bestellingen.stream().filter(x -> x.getZaakId() == id).collect(Collectors.toList());
        Zaak zaak = zr.findById(id).get();
        if (bestellingen != null) {
            double total = 0;
            double temp = 0;
            for (Bestelling bestelling : bestellingen) {
                temp = bestelling.getAantal() * bestelling.getMenuItem().getPrijs();
                total += temp;
            }
            Inkom inkom = new Inkom(zaak.getId(), zaak.getNaam(), total);
            return inkom;
        } else {
            return null;
        }
    }


}



