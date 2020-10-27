package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.BestellingVerzameling;
import be.multimedi.jammik.entities.Reservatie;
import be.multimedi.jammik.entities.Uitbater;
import be.multimedi.jammik.entities.Zaak;
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
class UitbaterRepositoryTest {

    private UitbaterRepository ur;

    @Autowired
    public UitbaterRepositoryTest(UitbaterRepository ur, OpeningsUrenRepository our) {
        this.ur = ur;
    }

    private String generateLongString() {
        StringBuilder sb = new StringBuilder();
        char c = 'A';
        for(int i = 0; i < 72; i++) {
            sb.append(c++);
        }

        return sb.toString();
    }

    @Test
    void getByEmail() {
        Uitbater uitbater = ur.getUitbaterByEmail("mehmet@jammik.be");
        assertNotNull(uitbater);
        assertEquals("Bistro Mehmet 2", uitbater.getZaken().get(1).getNaam());
    }

    @Test
    void findAll() {
        List<Uitbater> uitbaters = ur.findAll();
        assertNotNull(uitbaters);
        assertEquals(4, uitbaters.size());
    }

    @Test
    void save() {
        Uitbater uitbater = new Uitbater("nieuweuitbater@jammik.be", "Nieuwe", "Uitbater", generateLongString(), 1000d
                , List.of(new Reservatie()), List.of(new BestellingVerzameling()), List.of(new Zaak()));

        uitbater = ur.save(uitbater);
        assertEquals("nieuweuitbater@jammik.be", uitbater.getEmail());
    }

    @Test
    void deleteByEmail() {
        ur.deleteById("jan@jammik.be");
        assertEquals(3, ur.findAll().size());
    }
}