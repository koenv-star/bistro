package be.multimedi.jammik.controllers;

import be.multimedi.jammik.entities.Advertentie;
import be.multimedi.jammik.entities.Zaak;
import be.multimedi.jammik.repositories.AdvertentiesRepository;
import be.multimedi.jammik.repositories.ZaakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mehmet van Team-B
 */
@RestController
@RequestMapping("/advertenties")
public class AdvertentieController {


    private AdvertentiesRepository adr;
    private ZaakRepository zr;

    @Autowired
    public AdvertentieController(AdvertentiesRepository adr, ZaakRepository zr) {
        this.adr = adr;
        this.zr = zr;
    }

    @GetMapping
    public ResponseEntity<List<Advertentie>> getAllAdvertenties() {
        List<Advertentie> advertenties = adr.findAll();


        if (!advertenties.isEmpty()) {
            return new ResponseEntity<>(advertenties, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(path = "/{id:^\\d+$}")
    public ResponseEntity<Advertentie> getOneById(@PathVariable("id") int adId) {

        Advertentie ad = adr.findById(adId).get();

        return ad == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(ad);
    }

    @GetMapping(path = "/AdvertentiesLength")
    public ResponseEntity<Integer> getAllAdvertentiesLength() {
        List<Advertentie> advertentiesList = adr.findAll();
        advertentiesList = advertentiesList.stream().filter(x -> x.getNumberOfShow() > 0).collect(Collectors.toList());
        return ResponseEntity.ok(advertentiesList.size());
    }

    @GetMapping(path = "/Zaak/{id:^\\d+$}")
    public ResponseEntity<Zaak> getAdvertentieZaak(@PathVariable("id") int adId) {
        Advertentie ad = adr.findById(adId).get();
        int id = ad.getZaakId();
        int numberOfShow = ad.getNumberOfShow();
        if (numberOfShow - 1 > 0) {
            Zaak adZaak = zr.findById(id).get();
            ad.setNumberOfShow(numberOfShow - 1);
            adr.save(ad);
            return ResponseEntity.ok(adZaak);
        } else if (numberOfShow - 1 == 0) {
            Zaak adZaak = zr.findById(id).get();
            adr.deleteById(ad.getId());
            return ResponseEntity.ok(adZaak);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Advertentie> postHandler(@RequestBody Advertentie advertentie) {

        if (advertentie == null || advertentie.getId() != 0)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(adr.save(advertentie));
    }

    @PutMapping(path = "/{id:^\\d+$}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Advertentie> putHandler(@PathVariable("id") int id, @RequestBody Advertentie advertentie) {
        Advertentie tempAdvertentie = adr.getOne(id);
        if (tempAdvertentie != null) {
            tempAdvertentie.setNumberOfShow(advertentie.getNumberOfShow());
            tempAdvertentie.setZaakDesc(advertentie.getZaakDesc());
            tempAdvertentie.setZaakId(advertentie.getZaakId());
            tempAdvertentie.setZaakNaam(advertentie.getZaakNaam());
            return new ResponseEntity<>(adr.save(tempAdvertentie), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }


    @DeleteMapping(path = "/{id:^\\d+$}")
    public ResponseEntity<?> deleteHandler(@PathVariable("id") int id) {
        if (id <= 0) return ResponseEntity.badRequest().build();

        adr.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
