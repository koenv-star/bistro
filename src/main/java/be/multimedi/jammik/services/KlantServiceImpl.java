package be.multimedi.jammik.services;


import be.multimedi.jammik.entities.Klant;
import be.multimedi.jammik.repositories.KlantRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * made by Koen
 */
@Service
public class KlantServiceImpl {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private KlantRepository klantRepository;
    public List<Klant> findAllKlanten() {
        return klantRepository.findAll();
    }
    public Klant findKlantById(String email) {
        return klantRepository.findKlantByEmail(email).get();
    }
    public Klant saveKlant(Klant klant) {
        klant.setWachtwoord(encoder.encode(klant.getWachtwoord()));
        return klantRepository.save(klant);
    }



}
