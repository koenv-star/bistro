package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Tafel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Gemaakt door Jan
 */
public interface TafelRepository extends JpaRepository<Tafel, Integer> {

    default Tafel getTafelById(int id) {
        return getOne(id);
    }
}