package be.multimedi.jammik.services;

import be.multimedi.jammik.common.Gebruiker;
import be.multimedi.jammik.entities.Uitbater;
import be.multimedi.jammik.repositories.UitbaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * made by Koen
 */
@Service
public class UitbaterServiceImpl {

    private UitbaterRepository uitbaterRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public List<Uitbater> findAllUitbaters() {

        return uitbaterRepository.findAll();
    }

    public Uitbater findUitbaterByEmail(String email) {
        Optional<Uitbater> uitbater = uitbaterRepository.findById(email);
        if (uitbater.isPresent()) {
            return uitbater.get();
        } else return null;

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
