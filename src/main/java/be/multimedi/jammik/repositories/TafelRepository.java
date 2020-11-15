package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Tafel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Gemaakt door Jan
 */
@Repository
public interface TafelRepository extends JpaRepository<Tafel, Integer> {


}
