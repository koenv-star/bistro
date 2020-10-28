package be.multimedi.jammik.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Gemaakt door: Michael Creelle

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class KlantTest {
    private Klant klant;

    @BeforeEach
    void setUp() {
        klant = new Klant();
    }

    @Test
    void set_get_email() {
        String email = "jos@somemail.com";
        klant.setEmail(email);
        assertEquals(email, klant.getEmail());
    }

    @Test
    void throws_on_invalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> klant.setEmail("1@2.3>6"));
    }

    @Test
    void throws_on_null_email() {
        assertThrows(IllegalArgumentException.class, () -> klant.setEmail(null));
    }

    @Test
    void set_get_naam() {
        String naam = "jos";
        klant.setNaam(naam);
        assertEquals(naam, klant.getNaam());
    }

    @Test
    void throws_on_empty_naam() {
        assertThrows(IllegalArgumentException.class, () -> klant.setNaam(""));
    }

    @Test
    void throws_on_null_naam() {
        assertThrows(IllegalArgumentException.class, () -> klant.setNaam(null));
    }

    @Test
    void set_get_voornaam() {
        String voornaam = "jos";
        klant.setVoornaam(voornaam);
        assertEquals(voornaam, klant.getVoornaam());
    }

    @Test
    void throws_on_empty_voornaam() {
        assertThrows(IllegalArgumentException.class, () -> klant.setVoornaam(""));
    }

    @Test
    void throws_on_null_voornaam() {
        assertThrows(IllegalArgumentException.class, () -> klant.setVoornaam(null));
    }

    @Test
    void setWachtwoord() {
        String ww = "a".repeat(60);
        klant.setWachtwoord(ww);
        assertEquals(ww, klant.getWachtwoord());
    }

    @Test
    void throws_on_59long_wachtwoord() {
        assertThrows(IllegalArgumentException.class, () -> klant.setWachtwoord("a".repeat(59)));
    }

    @Test
    void throws_on_61long_wachtwoord() {
        assertThrows(IllegalArgumentException.class, () -> klant.setWachtwoord("a".repeat(61)));
    }

    @Test
    void throws_on_null_wachtwoord() {
        assertThrows(IllegalArgumentException.class, () -> klant.setWachtwoord(null));
    }

    @Test
    void set_get_krediet() {
        int krediet = 15;
        klant.setKrediet(krediet);
        assertEquals(krediet, klant.getKrediet());
    }

    @Test
    void throws_on_negative_krediet() {
        assertThrows(IllegalArgumentException.class, () -> klant.setKrediet(-1));
    }

    @Test
    void set_get_reservaties() {
        List<Reservatie> reservatieList = new ArrayList<>();
        klant.setReservaties(reservatieList);
        assertEquals(reservatieList, klant.getReservaties());
    }

    @Test
    void throws_on_null_reservaties() {
        assertThrows(IllegalArgumentException.class, () -> klant.setReservaties(null));
    }

    @Test
    void set_get_bestellingVerzamelingen() {
        List<BestellingVerzameling> bestellingVerzamelingList = new ArrayList<>();
        klant.setBestellingVerzamelingen(bestellingVerzamelingList);
        assertEquals(bestellingVerzamelingList, klant.getBestellingVerzamelingen());
    }

    @Test
    void throws_on_null_bestellingVerzameling() {
        assertThrows(IllegalArgumentException.class, () -> klant.setBestellingVerzamelingen(null));
    }

    @Test
    void getRole_returns_ROLE_KLANT() {
        assertEquals("ROLE_KLANT", klant.getRole());
    }
}