package be.multimedi.jammik.services;


import be.multimedi.jammik.entities.Klant;
import be.multimedi.jammik.repositories.KlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * made by Koen
 */
@Service
public class KlantServiceImpl {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private KlantRepository klantRepository;

    @Autowired
    public void setKlantRepository(KlantRepository klantRepository) {
        this.klantRepository = klantRepository;
    }

    public Klant saveKlant(Klant klant) {
        klant.setWachtwoord(encoder.encode(klant.getWachtwoord()));
        return klantRepository.save(klant);
    }


}
