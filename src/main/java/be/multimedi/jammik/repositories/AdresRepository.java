package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Adres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Gemaakt door Jan
 */
@Repository
public interface AdresRepository extends JpaRepository<Adres, Integer> {


    default Adres getAdresById(int id) {
        return getOne(id);
    }
}
