package be.multimedi.jammik.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Gemaakt door Jan
 */
class OpeningsUrenTest {

    OpeningsUren openingsUren;

    @BeforeEach
    private void makeOpeningsUren() {
        this.openingsUren = new OpeningsUren();
    }

    @Test
    void setId() {
        assertThrows(IllegalArgumentException.class, () -> openingsUren.setId(-1));

        openingsUren.setId(178);
        assertEquals(178, openingsUren.getId());
    }

    @Test
    void setDagen() {
        assertThrows(IllegalArgumentException.class, () -> openingsUren.setDagen(null));

        Dag ma = new Dag();
        ma.setNaam("ma");
        ma.setOpeningsUur(LocalTime.of(9, 30));
        ma.setSluitingsUur(LocalTime.of(12, 45));

        Dag zo = new Dag();
        zo.setNaam("di");
        zo.setOpeningsUur(LocalTime.of(17, 25));
        zo.setSluitingsUur(LocalTime.of(22, 0));

        List<Dag> dagen = new ArrayList<>(List.of(ma, zo));
        openingsUren.setDagen(dagen);
        assertEquals(2, openingsUren.getDagen().size());
    }
}