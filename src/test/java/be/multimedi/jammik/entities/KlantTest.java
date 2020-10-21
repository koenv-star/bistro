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
}