package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Dag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Gemaakt door Jan
 */
public interface DagRepository extends JpaRepository<Dag, String> {

    Dag getDagByNaam(String naam);
}