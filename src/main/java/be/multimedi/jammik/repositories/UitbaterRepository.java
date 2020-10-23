package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Uitbater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Gemaakt door Jan
 */
@Repository
public interface UitbaterRepository extends JpaRepository<Uitbater, String> {

    default Uitbater getUitbaterByEmail(String email) {
        return getOne(email);
    }
    Optional<Uitbater> findUitbaterByEmail(String email);
}
