package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Zaak;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Gemaakt door Jan
 */
public interface ZaakRepository extends JpaRepository<Zaak, Integer> {

    default Zaak getZaakById(int id) {
        return getOne(id);
    }
}