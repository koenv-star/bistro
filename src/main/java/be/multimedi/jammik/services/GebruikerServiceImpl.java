package be.multimedi.jammik.services;


import be.multimedi.jammik.common.Gebruiker;
import be.multimedi.jammik.entities.Klant;
import be.multimedi.jammik.entities.Uitbater;
import be.multimedi.jammik.repositories.KlantRepository;
import be.multimedi.jammik.repositories.UitbaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * made by Koen
 */
@Service
public class GebruikerServiceImpl implements UserDetailsService {

    private KlantRepository klantRepository;


    private UitbaterRepository uitbaterRepository;

    private Klant person;
    
    @Autowired
    public void setKlantRepository(KlantRepository klantRepository) {
        this.klantRepository = klantRepository;
    }

    @Autowired
    public void setUitbaterRepository(UitbaterRepository uitbaterRepository) {
        this.uitbaterRepository = uitbaterRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Klant> klant = klantRepository.findById(s);
        if (klant.isPresent()) {
            person = klant.get();
            return new Gebruiker(person);
        } else {
            Optional<Uitbater> uitbater = uitbaterRepository.findById(s);
            if (uitbater.isPresent()) {
                person = uitbater.get();
                return new Gebruiker(person);
            } else {
                throw new UsernameNotFoundException("Not found: " + s);
            }
        }
    }
}
