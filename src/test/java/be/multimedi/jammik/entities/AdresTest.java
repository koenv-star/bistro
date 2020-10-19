package be.multimedi.jammik.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Gemaakt door Jan
 */
class AdresTest {

    Adres adres;

    @BeforeEach
    public void makeAddress() {
        adres = new Adres();
    }

    @Test
    void setId() {
        assertThrows(IllegalArgumentException.class, () -> adres.setId(0));

        adres.setId(150);
        assertEquals(150, adres.getId());
    }

    @Test
    void setStraat() {
        assertThrows(IllegalArgumentException.class, () -> adres.setStraat(null));
        assertThrows(IllegalArgumentException.class, () -> adres.setStraat("a"));

        adres.setStraat("JammikStraat");
        assertEquals("JammikStraat", adres.getStraat());
    }

    @Test
    void setHuisNr() {
        assertThrows(IllegalArgumentException.class, () -> adres.setHuisNr(null));

        adres.setHuisNr("12B");
        assertEquals("12B", adres.getHuisNr());
    }

    @Test
    void setPostcode() {
        assertThrows(IllegalArgumentException.class, () -> adres.setPostcode(999));
        assertThrows(IllegalArgumentException.class, () -> adres.setPostcode(10000));

        adres.setPostcode(3000);
        assertEquals(3000, adres.getPostcode());
    }

    @Test
    void setGemeente() {
        assertThrows(IllegalArgumentException.class, () -> adres.setGemeente(null));
        assertThrows(IllegalArgumentException.class, () -> adres.setGemeente("h"));

        adres.setGemeente("Leuven");
        assertEquals("Leuven", adres.getGemeente());
    }
}