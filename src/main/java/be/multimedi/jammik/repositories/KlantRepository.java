package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Klant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Gemaakt door Jan
 */
@Repository
public interface KlantRepository extends JpaRepository<Klant, String> {

    Optional<Klant> findKlantByEmail(String email);

}
