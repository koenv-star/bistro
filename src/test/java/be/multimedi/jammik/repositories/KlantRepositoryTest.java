package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.BestellingVerzameling;
import be.multimedi.jammik.entities.Klant;
import be.multimedi.jammik.entities.Reservatie;
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
class KlantRepositoryTest {

    private KlantRepository klantRepository;
    private ReservatieRepository reservatieRepository;
    private BestellingVerzamelingRepository bestellingVerzamelingRepository;

    @Autowired
    public KlantRepositoryTest(KlantRepository klantRepository, ReservatieRepository reservatieRepository,
                               BestellingVerzamelingRepository bestellingVerzamelingRepository) {

        this.klantRepository = klantRepository;
        this.reservatieRepository = reservatieRepository;
        this.bestellingVerzamelingRepository = bestellingVerzamelingRepository;
    }

    private String generateLongString() {
        StringBuilder sb = new StringBuilder();
        char c = 'A';
        for(int i = 0; i < 60; i++) {
            sb.append(c++);
        }

        return sb.toString();
    }

    @Test
    void getByEmail() {
        Klant klant = klantRepository.getKlantByEmail("resto@rant.be");
        assertNotNull(klant);
        assertEquals("Resto", klant.getVoornaam());
    }

    @Test
    void findAll() {
        List<Klant> klanten = klantRepository.findAll();
        assertNotNull(klanten);
        assertEquals(3, klanten.size());
    }

    @Test
    void save() {
        List<Reservatie> reservaties = new ArrayList<>(List.of(
                reservatieRepository.getReservatieById(2),
                reservatieRepository.getReservatieById(3)));

        List<BestellingVerzameling> bestellingVerzamelingen = new ArrayList<>(List.of(
                bestellingVerzamelingRepository.getBestellingVerzamelingById(2),
                bestellingVerzamelingRepository.getBestellingVerzamelingById(3)));

        Klant klant = new Klant("java@mail.com", "test", "test", generateLongString(),
                857.2d, reservaties, bestellingVerzamelingen);

        klant = klantRepository.save(klant);
        assertEquals("java@mail.com", klant.getEmail());
    }

    @Test
    void deleteByEmail() {
        klantRepository.deleteById("test@klant.be");
        assertEquals(2, klantRepository.findAll().size());
    }
}