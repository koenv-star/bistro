package be.multimedi.jammik.repository;

import be.multimedi.jammik.klant.Klant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KlantRepository extends JpaRepository<Klant, Long> {

    Optional<Klant> findByNaamAndVoornaam(String naam, String voornaam);
}
