package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Gemaakt door Jan
 */
@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

}
