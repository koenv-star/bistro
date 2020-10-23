package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Reservatie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Gemaakt door Jan
 */
@Repository
public interface ReservatieRepository extends JpaRepository<Reservatie, Integer> {

    default Reservatie getReservatieById(int id) {
        return getOne(id);
    }
}
