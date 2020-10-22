package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Tafel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Gemaakt door Jan
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class TafelRepositoryTest {

    private TafelRepository tr;

    @Autowired
    public TafelRepositoryTest(TafelRepository tr) {
        this.tr = tr;
    }

    @Test
    void getById() {
        Tafel tafel = tr.getTafelById(2);
        assertNotNull(tafel);
        assertEquals(2, tafel.getStoelen());
    }

    @Test
    void findAll() {
        List<Tafel> tafels = tr.findAll();
        assertNotNull(tafels);
        assertEquals(3, tafels.size());
    }

    @Test
    void save() {
        Tafel tafel = new Tafel(0, 6);
        tafel = tr.save(tafel);
        assertEquals(4, tafel.getId());
    }

    @Test
    void deleteById() {
        tr.deleteById(1);
        assertEquals(2, tr.findAll().size());
    }
}