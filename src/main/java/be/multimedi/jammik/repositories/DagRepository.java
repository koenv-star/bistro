package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Dag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Gemaakt door Jan
 */
@Repository
public interface DagRepository extends JpaRepository<Dag, Integer> {



}
