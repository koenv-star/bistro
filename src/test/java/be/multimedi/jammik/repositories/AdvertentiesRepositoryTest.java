package be.multimedi.jammik.repositories;


import be.multimedi.jammik.entities.Advertentie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class AdvertentiesRepositoryTest {
        private AdvertentiesRepository adr;

   @Autowired
    public AdvertentiesRepositoryTest(AdvertentiesRepository adr) {
        this.adr = adr;
    }

    @Test
    void getAdvertentiesById() {
        Advertentie advertentie = adr.findById(1).get();
        assertNotNull(advertentie);
        assertEquals(1, advertentie.getId());
    }

    @Test
    void getAll() {
        List<Advertentie> advertenties = adr.findAll();
        assertNotNull(advertenties);
        assertEquals(2, advertenties.size());
    }
}
