package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.BestellingVerzameling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Gemaakt door Jan
 */
@Repository
public interface BestellingVerzamelingRepository extends JpaRepository<BestellingVerzameling, Integer> {

    default BestellingVerzameling getBestellingVerzamelingById(int id) {
        return getOne(id);
    }
    List<BestellingVerzameling> getAllBestellingVerzamelingsByKlant(String email);

    List<BestellingVerzameling> findAllByKlant (String email);
}
