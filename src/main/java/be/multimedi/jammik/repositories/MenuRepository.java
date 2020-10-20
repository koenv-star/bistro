package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Gemaakt door Jan
 */
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    default Menu getMenuById(int id) {
        return getOne(id);
    }
}