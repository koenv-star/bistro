package be.multimedi.jammik.controllers;


import be.multimedi.jammik.entities.Klant;
import be.multimedi.jammik.entities.Uitbater;
import be.multimedi.jammik.services.UitbaterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping
    public void registerUitbater(@RequestBody Uitbater uitbater) {
        this.uitbaterService.saveUitbater(uitbater);
    }

}
