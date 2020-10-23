package be.multimedi.jammik.services;


import be.multimedi.jammik.common.Gebruiker;
import be.multimedi.jammik.entities.Klant;
import be.multimedi.jammik.repositories.KlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class KlantServiceImpl implements UserDetailsService {

    private KlantRepository repo;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    public List<Klant> findAllEntities() {
        return repo.findAll();
    }


    public Klant findEntityById(String email) {
        return repo.getKlantByEmail(email);
    }


    public Klant saveEntity(Klant klant) {
        klant.setWachtwoord(encoder.encode(klant.getWachtwoord()));
        return repo.save(klant);
    }


    @Autowired
    public void setRepo(KlantRepository repo) {
        this.repo = repo;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Klant> klant = repo.findByNaamAndVoornaam(s.split(" ")[1], s.split(" ")[0]);

        if (klant.isPresent()) {
            return new Gebruiker(klant.get());
        } else {
            throw new UsernameNotFoundException("Not found: " + s);
        }
    }
}
