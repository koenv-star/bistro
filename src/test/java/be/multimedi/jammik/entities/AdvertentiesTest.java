package be.multimedi.jammik.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Mehmet van Team-B
 *
 * */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class AdvertentiesTest {
    private Advertentie advertentie;

    @BeforeEach
    void setUp() {
    advertentie = new Advertentie();
    }

    @Test
    void getZaakId() {

        int zaakid = 5;
        advertentie.setZaakId(zaakid);
        assertEquals(zaakid, advertentie.getZaakId());

    }

    @Test
    void setZaakId() {
        int zaakid = 5;
        advertentie.setZaakId(zaakid);
        assertEquals(zaakid, advertentie.getZaakId());
    }

    @Test
    void getId() {
        int id = 5;
        advertentie.setId(id);
        assertEquals(id, advertentie.getId());
    }

    @Test
    void setId() {
        int id = 5;
        advertentie.setId(id);
        assertEquals(id, advertentie.getId());
    }


    @Test
    void getZaakNaam() {
        String zaaknaam = "Starbucks";
        advertentie.setZaakNaam(zaaknaam);
        assertEquals(zaaknaam, advertentie.getZaakNaam());
    }

    @Test
    void setZaakNaam() {

        String zaaknaam = "Starbucks";
        advertentie.setZaakNaam(zaaknaam);
        assertEquals(zaaknaam, advertentie.getZaakNaam());
    }

    @Test
    void getZaakDesc() {
        String zaakDesc = "The best Coffee";
        advertentie.setZaakDesc(zaakDesc);
        assertEquals(zaakDesc, advertentie.getZaakDesc());
    }

    @Test
    void setZaakDesc() {
        String zaakDesc = "The best Coffee";
        advertentie.setZaakDesc(zaakDesc);
        assertEquals(zaakDesc, advertentie.getZaakDesc());
    }

    @Test
    void getNumberOfShow() {
        int numberOfShow = 3000;
        advertentie.setNumberOfShow(numberOfShow);
        assertEquals(numberOfShow, advertentie.getNumberOfShow());

    }

    @Test
    void setNumberOfShow() {
        int numberOfShow = 3000;
        advertentie.setNumberOfShow(numberOfShow);
        assertEquals(numberOfShow, advertentie.getNumberOfShow());

    }
}
