package be.multimedi.jammik.services;

import be.multimedi.jammik.entities.Zaak;
import be.multimedi.jammik.repositories.ZaakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * made by Koen
 */
@Service
public class ZaakServiceImpl {
    private ZaakRepository repository;

    @Autowired
    public void setRepository(ZaakRepository repository) {
        this.repository = repository;
    }


    public List<Zaak> getZakenOpUitbater(String email) {

        return repository.findZaaksByUitbaterEmail(email).get();

    }
    public List<Zaak> getAlleZaken() {
        repository.findAll().stream().forEach(System.out::println);

        return repository.findAll();

    }
}
