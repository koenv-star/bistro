package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Reservatie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Gemaakt door Jan
 */
@Repository
public interface ReservatieRepository extends JpaRepository<Reservatie, Integer> {


    Optional<ArrayList<Reservatie>> findReservatiesByZaak(int id);
}
