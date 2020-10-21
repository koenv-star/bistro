package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Adres;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Gemaakt door Jan
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class AdresRepositoryTest {

    private AdresRepository adresRepository;

    @Autowired
    public AdresRepositoryTest(AdresRepository adresRepository) {
        this.adresRepository = adresRepository;
    }

    @Test
    void getAdresById() {
        Adres adres = adresRepository.getAdresById(1);
        assertNotNull(adres);
        assertEquals("JavaStraat", adres.getStraat());
    }

    @Test
    void findAll() {
        List<Adres> adressen = adresRepository.findAll();
        assertNotNull(adressen);
        assertEquals(3, adressen.size());
    }

    @Test
    void save() {
        Adres adres = new Adres();
        adres.setId(0);
        adres.setStraat("HibernateStraat");
        adres.setHuisNr("15");
        adres.setGemeente("JavaMeerbeek");
        adres.setPostcode(1000);
        Adres savedAdres = adresRepository.save(adres);
        assertEquals(4, savedAdres.getId());
    }

    @Test
    void deleteById() {
        adresRepository.deleteById(3);

        List<Adres> adressen = adresRepository.findAll();
        assertEquals(2, adressen.size());
    }
}