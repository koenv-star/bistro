package be.multimedi.jammik.controllers;

import be.multimedi.jammik.entities.Advertenties;
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
public class AdvertentiesController {


    private AdvertentiesRepository adr;
    private ZaakRepository zr;

    @Autowired
    public AdvertentiesController(AdvertentiesRepository adr, ZaakRepository zr) {
        this.adr = adr;
        this.zr = zr;
    }

    @GetMapping
    public ResponseEntity<List<Advertenties>> getAllAdvertenties() {
        return ResponseEntity.ok(adr.getAll());

    }
    @GetMapping(path = "/{id:^\\d+$}")
    public ResponseEntity<Advertenties> getOneById(@PathVariable("id") int adId){
        return  ResponseEntity.ok(adr.getAll().get(adId));
    }

    @GetMapping(path = "/AdvertentiesLength")
    public ResponseEntity<Integer> getAllAdvertentiesLength() {
        List<Advertenties> advertentiesList = adr.getAll();
        advertentiesList = advertentiesList.stream().filter(x -> x.getNumberOfShow() > 0).collect(Collectors.toList());
        return ResponseEntity.ok(advertentiesList.size());
    }

    @GetMapping(path = "/Zaak/{id:^\\d+$}")
    public ResponseEntity<Zaak> getAdvertentieZaak(@PathVariable("id") int adId) {
        // getting ad from database according to given id
        //if the the showing number is bigger then 0 then we turning back to restaurant info
        Advertenties ad = adr.getAll().get(adId);
        int numberOfShow = ad.getNumberOfShow();

        //if showing number -1 is bigger than 0 then needed to update the ad show number
        //and returning to ad restaurant info according to advertisement id
        if ( numberOfShow - 1 > 0) {
            Zaak adZaak = zr.getZaakById(ad.getZaakId());
            ad.setNumberOfShow(numberOfShow-1);
            adr.save(ad);
            return ResponseEntity.ok(adZaak);
        }else if(numberOfShow-1 == 0) {
            Zaak adZaak = zr.getZaakById(ad.getZaakId());
            adr.deleteById(ad.getId());
            return ResponseEntity.ok(adZaak);
        }else{
            return ResponseEntity.badRequest().build();
        }

    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Advertenties> postHandler(@RequestBody Advertenties advertentie) {

        if (advertentie == null || advertentie.getId() != 0)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(adr.save(advertentie));
    }

    //Updating the Advertentie object
    @PutMapping(path = "/{id:^\\d+$}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Advertenties> putHandler(@PathVariable("id") int id, @RequestBody Advertenties advertentie) {
        Advertenties tempAdvertentie = adr.getAdvertentiesById(id);
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
