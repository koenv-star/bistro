package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Dag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Gemaakt door Jan
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class DagRepositoryTest {

    private DagRepository dagRepository;

    @Autowired
    public DagRepositoryTest(DagRepository dagRepository) {
        this.dagRepository = dagRepository;
    }

    @Test
    void getByNaam() {
        Dag dag = dagRepository.getDagByNaam("Wo");
        assertNotNull(dag);
        assertEquals("08:15", dag.getOpeningsUur().toString());
    }

    @Test
    void findAll() {
        List<Dag> dagen = dagRepository.findAll();
        assertEquals(3, dagen.size());
    }

    @Test
    void save() {
        Dag dag = new Dag("Za", LocalTime.of(9, 15), LocalTime.of(18, 0));
        dag = dagRepository.save(dag);
        assertEquals("Za", dag.getNaam());
        assertEquals(4, dagRepository.findAll().size());
    }

    @Test
    void deleteById() {
        dagRepository.deleteById("Wo");
        assertEquals(2, dagRepository.findAll().size());
    }
}