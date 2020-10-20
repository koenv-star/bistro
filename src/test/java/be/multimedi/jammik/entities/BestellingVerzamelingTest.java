package be.multimedi.jammik.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Gemaakt door: Michael Creelle

class BestellingVerzamelingTest {

    private BestellingVerzameling bestellingVerzameling;

    @BeforeEach
    void setUp() {
        bestellingVerzameling = new BestellingVerzameling();
    }

    @Test
    void set_get_id() {
        int id = 5;
        bestellingVerzameling.setId(id);
        assertEquals(id, bestellingVerzameling.getId());
    }

    @Test
    void throw_exception_on_negative_id(){
        assertThrows(IllegalArgumentException.class, () -> bestellingVerzameling.setId(-1));
    }

    @Test
    void throw_exception_on_0_id() {
        assertThrows(IllegalArgumentException.class, () -> bestellingVerzameling.setId(0));
    }

    @Test
    void set_get_bestellingen() {
        List<Bestelling> bestellingen = new ArrayList<>();
        bestellingen.add(new Bestelling());
        bestellingVerzameling.setBestellingen(bestellingen);
        assertEquals(bestellingen, bestellingVerzameling.getBestellingen());
    }

    @Test
    void throws_exception_on_null_menuItems() {
        assertThrows(IllegalArgumentException.class, () -> bestellingVerzameling.setBestellingen(null));
    }

    @Test
    void throws_exception_on_empty_list_menuItems() {
        assertThrows(IllegalArgumentException.class, () -> bestellingVerzameling.setBestellingen(new ArrayList<>()));
    }
}