package be.multimedi.jammik.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Gemaakt door: Michael Creelle

class TafelTest {
    private Tafel tafel;

    @BeforeEach
    void setUp() {
        tafel = new Tafel();
    }

    @Test
    void set_get_id() {
        tafel.setId(5);
        assertEquals(5, tafel.getId());
    }

    @Test
    void throw_on_negative_id(){
        assertThrows(IllegalArgumentException.class, () -> tafel.setId(-1));
    }

    @Test
    void throw_on_0_id() {
        assertThrows(IllegalArgumentException.class, () -> tafel.setId(0));
    }

    @Test
    void set_get_stoelen() {
        tafel.setStoelen(5);
        assertEquals(5, tafel.getStoelen());
    }
}