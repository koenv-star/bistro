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
class UitbaterTest {
    private Uitbater uitbater;

    @BeforeEach
    void setUp() {
        uitbater = new Uitbater();
    }

    @Test
    void set_get_zaken() {
        List<Zaak> zaken = new ArrayList<>();
        uitbater.setZaken(zaken);
    }

    @Test
    void throws_on_null_zaken() {
        assertThrows(IllegalArgumentException.class, () -> uitbater.setZaken(null));
    }
}