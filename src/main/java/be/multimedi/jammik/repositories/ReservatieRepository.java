package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Reservatie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Gemaakt door Jan
 */
@Repository
public interface ReservatieRepository extends JpaRepository<Reservatie, Integer> {

    default Reservatie getReservatieById(int id) {
        return getOne(id);
    }

    Optional<List<Reservatie>> findReservatiesByZaakId(Integer integer);
}
