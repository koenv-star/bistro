package be.multimedi.jammik.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

// Gemaakt door: Michael Creelle

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
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
    void set_get_stoelen() {
        tafel.setStoelen(5);
        assertEquals(5, tafel.getStoelen());
    }

    @Test
    void throw_on_0_and_negative_stoelen() {
        assertThrows(IllegalArgumentException.class, () -> tafel.setStoelen(0));
        assertThrows(IllegalArgumentException.class, () -> tafel.setStoelen(-1));
    }
}