package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Advertentie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mehmet van Team-B
 */
@Repository
public interface AdvertentiesRepository extends JpaRepository<Advertentie, Integer> {


}
