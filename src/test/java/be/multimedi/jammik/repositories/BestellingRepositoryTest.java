package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Bestelling;
import be.multimedi.jammik.entities.MenuItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Gemaakt door Jan
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class BestellingRepositoryTest {

    private BestellingRepository bestellingRepository;

    @Autowired
    public BestellingRepositoryTest(BestellingRepository bestellingRepository) {
        this.bestellingRepository = bestellingRepository;
    }

    @Test
    void getById() {
        Bestelling bestelling = bestellingRepository.getBestellingById(2);
        assertNotNull(bestelling);
        assertEquals(2, bestelling.getId());
        assertEquals(2, bestelling.getMenuItems().size());
        assertEquals("Spaghetti", bestelling.getMenuItems().get(1).getNaam());
    }

    @Test
    void findAll() {
        List<Bestelling> bestellingen = bestellingRepository.findAll();
        assertNotNull(bestellingen);
        assertEquals(3, bestellingen.size());
    }

    @Test
    void save() {
        Bestelling bestelling = new Bestelling();

        MenuItem mi1 = new MenuItem();
        mi1.setId(5);
        mi1.setNaam("Gentse Waterzooi");
        mi1.setPrijs(13.25f);

        MenuItem mi2 = new MenuItem();
        mi2.setId(3);
        mi2.setNaam("Cornflakes");
        mi2.setPrijs(5.99f);

        bestelling.setMenuItems(new ArrayList<>(List.of(mi1, mi2)));

        bestelling = bestellingRepository.save(bestelling);
        assertEquals(4, bestelling.getId());
    }

    @Test
    void deleteById() {
        bestellingRepository.deleteById(2);
        assertEquals(2, bestellingRepository.findAll().size());
    }
}