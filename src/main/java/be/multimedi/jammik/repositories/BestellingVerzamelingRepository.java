package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.BestellingVerzameling;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Gemaakt door Jan
 */
public interface BestellingVerzamelingRepository extends JpaRepository<BestellingVerzameling, Integer> {

    default BestellingVerzameling getBestellingVerzamelingById(int id) {
        return getOne(id);
    }
}