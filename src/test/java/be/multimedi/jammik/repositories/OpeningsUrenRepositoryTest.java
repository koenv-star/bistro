package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.OpeningsUren;
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
class OpeningsUrenRepositoryTest {

    private OpeningsUrenRepository our;
    private DagRepository dr;

    @Autowired
    public OpeningsUrenRepositoryTest(OpeningsUrenRepository our, DagRepository dr) {
        this.our = our;
        this.dr = dr;
    }

    @Test
    void getById() {
        OpeningsUren ou = our.findById(2).get();
        assertNotNull(ou);
        assertEquals("Di", ou.getDagen().get(0).getNaam());
    }

    @Test
    void findAll() {
        List<OpeningsUren> ourn = our.findAll();
        assertNotNull(ourn);
        assertEquals(3, ourn.size());
    }

    @Test
    void save() {
        OpeningsUren ourn = new OpeningsUren(0, List.of(
                dr.findById(1).get(),
                dr.findById(2).get()
        ));

        ourn = our.save(ourn);
        assertEquals(4, ourn.getId());
    }

    @Test
    void deleteById() {
        our.deleteById(3);
        assertEquals(2, our.findAll().size());
    }
}
