package be.multimedi.jammik.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

// Gemaakt door: Michael Creelle

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class DagTest {
    private Dag dag;

    @BeforeEach
    void setUp() {
        dag = new Dag();
    }

    @Test
    void set_get_Id() {
        dag.setId(15);
        assertEquals(15, dag.getId());
    }

    @Test
    void throws_on_negative_id() {
        assertThrows(IllegalArgumentException.class, () -> dag.setId(-1));
    }

    @Test
    void set_get_naam() {
        String naam = "someday";
        dag.setNaam(naam);
        assertEquals(naam, dag.getNaam());
    }

    @Test
    void throws_on_null_naam() {
        assertThrows(IllegalArgumentException.class, () -> dag.setNaam(null));
    }

    @Test
    void throws_on_empty_naam() {
        assertThrows(IllegalArgumentException.class, () -> dag.setNaam(""));
    }

    @Test
    void set_get_openingsUur() {
        LocalTime time = LocalTime.of(9,0);
        dag.setOpeningsUur(time);
        assertEquals(time, dag.getOpeningsUur());
    }

    @Test
    void throws_on_null_openingsUur() {
        assertThrows(IllegalArgumentException.class, () -> dag.setOpeningsUur(null));
    }

    @Test
    void set_get_sluitingsUur() {
        LocalTime time = LocalTime.of(18,0);
        dag.setSluitingsUur(time);
        assertEquals(time, dag.getSluitingsUur());
    }

    @Test
    void throws_on_null_sluitingsUur() {
        assertThrows(IllegalArgumentException.class, () -> dag.setSluitingsUur(null));
    }

    @Test
    void throws_on_openingsUur_after_sluitingsUur() {
        LocalTime early = LocalTime.of(9,0);
        LocalTime late  = LocalTime.of(18,0);
        dag.setSluitingsUur(early);
        assertThrows(IllegalArgumentException.class, () -> dag.setOpeningsUur(late));
    }

    @Test
    void throws_on_sluitingsUur_before_openingsUur() {
        LocalTime early = LocalTime.of(9,0);
        LocalTime late  = LocalTime.of(18,0);
        dag.setOpeningsUur(late);
        assertThrows(IllegalArgumentException.class, () -> dag.setSluitingsUur(early));
    }
}