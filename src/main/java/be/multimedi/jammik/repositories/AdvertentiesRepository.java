package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Advertenties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Mehmet van Team-B
 */
@Repository
public interface AdvertentiesRepository extends JpaRepository<Advertenties, Integer> {

    default Advertenties getAdvertentiesById(int id) {
        return getOne(id);
    }
    default List<Advertenties> getAll() {
        return findAll();
    }

}
