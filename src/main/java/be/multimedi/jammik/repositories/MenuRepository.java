package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Gemaakt door Jan
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    default Menu getMenuById(int id) {
        return getOne(id);
    }


}
