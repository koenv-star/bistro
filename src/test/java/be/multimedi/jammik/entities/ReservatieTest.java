package be.multimedi.jammik.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Gemaakt door Jan
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class ReservatieTest {

    private Reservatie reservatie;

    @BeforeEach
    private void makeReservatie() {
        reservatie = new Reservatie();
    }

    @Test
    void setId() {
        assertThrows(IllegalArgumentException.class, () -> reservatie.setId(-1));

        reservatie.setId(123);
        assertEquals(123, reservatie.getId());
    }

    @Test
    void setWanneer() {
        assertThrows(IllegalArgumentException.class, () -> reservatie.setTijdstip(null));
        assertThrows(IllegalArgumentException.class, () -> reservatie.setTijdstip(LocalDateTime.of(2019, 8, 12, 11, 50)));

        reservatie.setTijdstip(LocalDateTime.of(2021, 1, 10, 12, 0));
        assertEquals("2021-01-10T12:00", reservatie.getTijdstip().toString());
    }

    @Test
    void setUurMarge() {
        assertThrows(IllegalArgumentException.class, () -> reservatie.setUurMarge(null));

        reservatie.setUurMarge(LocalTime.of(10, 20));
        assertEquals("10:20", reservatie.getUurMarge().toString());
    }

    @Test
    void setTotaal() {
        assertThrows(IllegalArgumentException.class, () -> reservatie.setTotaal(-1d));
        assertThrows(IllegalArgumentException.class, () -> reservatie.setTotaal(1.205));

        reservatie.setTotaal(10.30);
        assertEquals(10.30, reservatie.getTotaal());
    }

    @Test
    void setKlant() {
        assertThrows(IllegalArgumentException.class, () -> reservatie.setPerson(null));

        Klant klant = new Klant();
        klant.setEmail("test@test.be");
        reservatie.setPerson(klant);
        assertEquals("test@test.be", reservatie.getPerson().getEmail());
    }

    @Test
    void setZaak() {
        assertThrows(IllegalArgumentException.class, () -> reservatie.setZaak(null));

        Zaak zaak = new Zaak();
        zaak.setNaam("TestZaak");
        reservatie.setZaak(zaak);
        assertEquals("TestZaak", reservatie.getZaak().getNaam());
    }

    @Test
    void setTafel() {
        assertThrows(IllegalArgumentException.class, () -> reservatie.setTafel(null));

        Tafel tafel = new Tafel();
        tafel.setId(5);
        reservatie.setTafel(tafel);
        assertEquals(5, reservatie.getTafel().getId());
    }
}