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
        assertEquals("Spaghetti", bestelling.getMenuItem().getNaam());
    }

    @Test
    void findAll() {
        List<Bestelling> bestellingen = bestellingRepository.findAll();
        assertNotNull(bestellingen);
        assertEquals(4, bestellingen.size());
    }

    @Test
    void save() {
        Bestelling bestelling = new Bestelling();
        bestelling.setMenuItem(new MenuItem());
        bestelling.setZaakId(3);

        bestelling = bestellingRepository.save(bestelling);
        assertEquals(5, bestelling.getId());
    }

    @Test
    void deleteById() {
        bestellingRepository.deleteById(2);
        assertEquals(3, bestellingRepository.findAll().size());
    }
}