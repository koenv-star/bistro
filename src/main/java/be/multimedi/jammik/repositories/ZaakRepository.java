package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Zaak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Gemaakt door Jan
 */
@Repository
public interface ZaakRepository extends JpaRepository<Zaak, Integer> {

    default Zaak getZaakById(int id) {
        return getOne(id);
    }
}
