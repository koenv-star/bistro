package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.OpeningsUren;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Gemaakt door Jan
 */
public interface OpeningsUrenRepository extends JpaRepository<OpeningsUren, Integer> {

    default OpeningsUren getOpeningsUrenById(int id) {
        return getOne(id);
    }
}