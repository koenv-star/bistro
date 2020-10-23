package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Klant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Gemaakt door Jan
 */
public interface KlantRepository extends JpaRepository<Klant, String> {

    default Klant getKlantByEmail(String email) {
        return getOne(email);
    }
    Optional<Klant> findByNaamAndVoornaam(String naam, String voornaam);
}
