package be.multimedi.jammik.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Gemaakt door Jan
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class ZaakTest {

    private Zaak zaak;

    @BeforeEach
    private void makeZaak() {
        this.zaak = new Zaak();
    }

    @Test
    void setId() {
        assertThrows(IllegalArgumentException.class, () -> zaak.setId(-1));

        zaak.setId(563);
        assertEquals(563, zaak.getId());
    }

    @Test
    void setNaam() {
        assertThrows(IllegalArgumentException.class, () -> zaak.setNaam(null));

        zaak.setNaam("TestZaak");
        assertEquals("TestZaak", zaak.getNaam());
    }

    @Test
    void setParking() {
        zaak.setParking(true);
        assertTrue(zaak.heeftParking());
    }

    @Test
    void setRating() {
        assertThrows(IllegalArgumentException.class, () -> zaak.setRating(-0.1f));
        assertThrows(IllegalArgumentException.class, () -> zaak.setRating(5.1f));

        zaak.setRating(4.3f);
        assertEquals(4.3f, zaak.getRating());
    }

    @Test
    void setOpeningsUren() {
        assertThrows(IllegalArgumentException.class, () -> zaak.setOpeningsUren(null));

        OpeningsUren openingsUren = new OpeningsUren();
        openingsUren.setId(587);
        zaak.setOpeningsUren(openingsUren);

        assertEquals(587, zaak.getOpeningsUren().getId());
    }

    @Test
    void setAdres() {
        assertThrows(IllegalArgumentException.class, () -> zaak.setAdres(null));

        Adres adres = new Adres();
        adres.setId(963);
        zaak.setAdres(adres);

        assertEquals(963, zaak.getAdres().getId());
    }

    @Test
    void setMenu() {
        assertThrows(IllegalArgumentException.class, () -> zaak.setMenu(null));

        Menu menu = new Menu();
        menu.setId(854);
        zaak.setMenu(menu);

        assertEquals(854, zaak.getMenu().getId());
    }

    @Test
    void setUitbater() {
        assertThrows(IllegalArgumentException.class, () -> zaak.setUitbater(null));

        Uitbater uitbater = new Uitbater();
        uitbater.setEmail("uitbater@test.com");
        zaak.setUitbater(uitbater);

        assertEquals("uitbater@test.com", zaak.getUitbater().getEmail());
    }

    @Test
    void setTafels() {
        assertThrows(IllegalArgumentException.class, () -> zaak.setTafels(null));

        Tafel tafel1 = new Tafel();
        tafel1.setId(5);

        Tafel tafel2 = new Tafel();
        tafel2.setId(9);

        List<Tafel> tafels = new ArrayList(List.of(tafel1, tafel2));

        zaak.setTafels(tafels);
        assertEquals(2, zaak.getTafels().size());
    }

    @Test
    void setReservaties() {
        assertThrows(IllegalArgumentException.class, () -> zaak.setReservaties(null));

        Reservatie reservatie1 = new Reservatie();
        reservatie1.setId(6);

        Reservatie reservatie2 = new Reservatie();
        reservatie2.setId(8);

        List<Reservatie> reservaties = new ArrayList<>(List.of(reservatie1, reservatie2));
        zaak.setReservaties(reservaties);

        assertEquals(2, zaak.getReservaties().size());
    }

    @Test
    void setBestellingen() {
        List<Bestelling> bestellingen = new ArrayList<>();
        bestellingen.add(new Bestelling());
        bestellingen.add(new Bestelling());
        zaak.setBestellingen(bestellingen);
        assertEquals(2, zaak.getBestellingen().size());
    }

    @Test
    void throws_exception_on_null_bestellingen() {
        assertThrows(IllegalArgumentException.class, () -> zaak.setBestellingen(null));
    }
}