package be.multimedi.jammik.controllers;


import be.multimedi.jammik.entities.Uitbater;
import be.multimedi.jammik.services.UitbaterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Made by Koennnn
 */


@RestController
@RequestMapping("uitbaters")
@CrossOrigin()
public class UitbaterController {

    private UitbaterServiceImpl uitbaterService;


    @Autowired
    public void setUitbaterService(UitbaterServiceImpl uitbaterService) {
        this.uitbaterService = uitbaterService;
    }


    @GetMapping()
    public List<Uitbater> getAll(){  return  uitbaterService.findAllUitbaters();}

    @PostMapping
    public Uitbater registerUitbater(@RequestBody Uitbater uitbater) {
       return this.uitbaterService.saveUitbater(uitbater);
    }

}
