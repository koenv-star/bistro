package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Reservatie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Gemaakt door Jan
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class ReservatieRepositoryTest {

    private ReservatieRepository rr;
    private KlantRepository kr;
    private ZaakRepository zr;
    private TafelRepository tr;

    @Autowired
    public ReservatieRepositoryTest(ReservatieRepository rr, KlantRepository kr, ZaakRepository zr, TafelRepository tr) {
        this.rr = rr;
        this.kr = kr;
        this.zr = zr;
        this.tr = tr;
    }

    @Test
    void getById() {
        Reservatie reservatie = rr.getReservatieById(3);
        assertNotNull(reservatie);
        assertEquals("jammik@bistro.be", reservatie.getPerson().getEmail());
    }

    @Test
    void findAll() {
        List<Reservatie> reservaties = rr.findAll();
        assertNotNull(reservaties);
        assertEquals(3, reservaties.size());
    }

    @Test
    void save() {
        Reservatie reservatie = new Reservatie(0, LocalDateTime.of(2021, 12, 25, 9, 15),
                LocalTime.of(1, 0), kr.getKlantByEmail("jammik@bistro.be"), zr.getZaakById(2), tr.getTafelById(1));

        reservatie = rr.save(reservatie);
        assertEquals(4, reservatie.getId());
    }

    @Test
    void deleteById() {
        rr.deleteById(2);
        assertEquals(2, rr.findAll().size());
    }
}