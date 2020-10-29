package be.multimedi.jammik.controllers;


import be.multimedi.jammik.entities.Uitbater;
import be.multimedi.jammik.repositories.UitbaterRepository;
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

    private UitbaterRepository repository;

    @Autowired
    public void setRepository(UitbaterRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setUitbaterService(UitbaterServiceImpl uitbaterService) {
        this.uitbaterService = uitbaterService;
    }


    @GetMapping()
    public List<Uitbater> getAll(){  return  uitbaterService.findAllUitbaters();}

//    @GetMapping()
//    public List<Uitbater> getAll() {
//        return repository.findAll();
//    }

    @PostMapping
    public Uitbater registerUitbater(@RequestBody Uitbater uitbater) {
        return this.uitbaterService.saveUitbater(uitbater);
    }

}
