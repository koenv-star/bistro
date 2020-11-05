package be.multimedi.jammik.repositories;

import be.multimedi.jammik.common.Categorie;
import be.multimedi.jammik.entities.MenuItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Gemaakt door Jan
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MenuItemRepositoryTest {

    private MenuItemRepository mir;

    @Autowired
    public MenuItemRepositoryTest(MenuItemRepository mir) {
        this.mir = mir;
    }

    @Test
    void getById() {
        MenuItem menuItem = mir.getMenuItemById(2);
        assertNotNull(menuItem);
        assertEquals("Spaghetti", menuItem.getNaam());
    }

    @Test
    void findAll() {
        List<MenuItem> menuItems = mir.findAll();
        assertNotNull(menuItems);
        assertEquals(3, menuItems.size());
    }

    @Test
    void save() {
        MenuItem menuItem = new MenuItem(0, "Aji de Gallina", 25.5f,"lekker gerechtje", Categorie.DESSERTEN);
        menuItem = mir.save(menuItem);
        assertEquals(4, menuItem.getId());
    }

    @Test
    void deleteById() {
        mir.deleteById(3);
        assertEquals(2, mir.findAll().size());
    }
}
