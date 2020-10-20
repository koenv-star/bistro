package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Adres;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Gemaakt door Jan
 */
public interface AdresRepository extends JpaRepository<Adres, Integer> {


    default Adres getAdresById(int id) {
        return getOne(id);
    }
}