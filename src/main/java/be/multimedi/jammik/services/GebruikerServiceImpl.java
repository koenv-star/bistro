package be.multimedi.jammik.services;


import be.multimedi.jammik.common.Gebruiker;
import be.multimedi.jammik.entities.Person;
import be.multimedi.jammik.repositories.KlantRepository;
import be.multimedi.jammik.repositories.UitbaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * made by Koen
 */
@Service
public class GebruikerServiceImpl implements UserDetailsService {

    private KlantRepository klantRepository;


    private UitbaterRepository uitbaterRepository;

    private Person person;

    public Person getPerson() {
        return person;
    }

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
     person = klantRepository.getKlantByEmail(s);
        System.out.println(person.getNaam());


        if (person != null) {
            return new Gebruiker(person);
        } else {
          person = uitbaterRepository.getUitbaterByEmail(s);
            if (person!= null) {
                return new Gebruiker(person);
            } else {
                throw new UsernameNotFoundException("Not found: " + s);
            }
        }
    }
}
