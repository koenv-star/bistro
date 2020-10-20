package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Uitbater;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Gemaakt door Jan
 */
public interface UitbaterRepository extends JpaRepository<Uitbater, String> {

    default Uitbater getUitbaterByEmail(String email) {
        return getOne(email);
    }
}