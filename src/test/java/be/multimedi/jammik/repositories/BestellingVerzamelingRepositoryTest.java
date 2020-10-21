package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Bestelling;
import be.multimedi.jammik.entities.BestellingVerzameling;
import be.multimedi.jammik.entities.MenuItem;
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
class BestellingVerzamelingRepositoryTest {

    private BestellingVerzamelingRepository bestellingVerzamelingRepository;
    private BestellingRepository bestellingRepository;

    @Autowired
    public BestellingVerzamelingRepositoryTest(BestellingVerzamelingRepository bestellingVerzamelingRepository,
                                               BestellingRepository bestellingRepository) {

        this.bestellingVerzamelingRepository = bestellingVerzamelingRepository;
        this.bestellingRepository = bestellingRepository;
    }

    @Test
    void getById() {
        BestellingVerzameling bestellingVerzameling =
                bestellingVerzamelingRepository.getBestellingVerzamelingById(2);

        assertNotNull(bestellingVerzameling);
        assertEquals(2, bestellingVerzameling.getBestellingen().size());
        assertEquals(1, bestellingVerzameling.getBestellingen().get(0).getMenuItems().size());
        assertEquals("Spaghetti", bestellingVerzameling.getBestellingen().get(0).getMenuItems().get(0).getNaam());
    }

    @Test
    void findAll() {
        List<BestellingVerzameling> bestellingVerzamelingen =
                bestellingVerzamelingRepository.findAll();

        assertEquals(3, bestellingVerzamelingen.size());
    }

    @Test
    void save() {
        BestellingVerzameling bv = new BestellingVerzameling(0, List.of(
                bestellingRepository.getBestellingById(2),
                bestellingRepository.getBestellingById(3)
        ));

        bv = bestellingVerzamelingRepository.save(bv);
        assertEquals(4, bv.getId());
    }

    @Test
    void deleteById() {
        bestellingVerzamelingRepository.deleteById(3);
        assertEquals(2, bestellingVerzamelingRepository.findAll().size());
    }
}