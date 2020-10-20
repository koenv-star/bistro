package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Bestelling;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Gemaakt door Jan
 */
public interface BestellingRepository extends JpaRepository<Bestelling, Integer> {

    default Bestelling getBestellingById(int id) {
        return getOne(id);
    }
}