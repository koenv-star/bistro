package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.BestellingVerzameling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Gemaakt door Jan
 */
@Repository
public interface BestellingVerzamelingRepository extends JpaRepository<BestellingVerzameling, Integer> {

    default BestellingVerzameling getBestellingVerzamelingById(int id) {
        return getOne(id);
    }
}
