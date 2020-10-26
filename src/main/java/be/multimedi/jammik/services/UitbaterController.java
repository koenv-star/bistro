package be.multimedi.jammik.services;

import be.multimedi.jammik.entities.Klant;
import be.multimedi.jammik.entities.Uitbater;
import be.multimedi.jammik.repositories.UitbaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * made by Koen
 */
@Service
public class UitbaterController {

    private UitbaterRepository uitbaterRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public List<Uitbater> findAllUitbaters() {

        return uitbaterRepository.findAll();
    }

    public Uitbater saveUitbater(Uitbater uitbater) {
        uitbater.setWachtwoord(encoder.encode(uitbater.getWachtwoord()));
        return uitbaterRepository.save(uitbater);
    }

    @Autowired
    public void setUitbaterRepository(UitbaterRepository uitbaterRepository) {
        this.uitbaterRepository = uitbaterRepository;
    }
}
