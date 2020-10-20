package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Gemaakt door Jan
 */
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

    default MenuItem getMenuItemById(int id) {
        return getOne(id);
    }
}