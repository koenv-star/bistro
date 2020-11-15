package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Bestelling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Gemaakt door Jan
 */
@Repository
public interface BestellingRepository extends JpaRepository<Bestelling, Integer> {


}
