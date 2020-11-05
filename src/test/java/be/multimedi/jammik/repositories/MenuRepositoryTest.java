package be.multimedi.jammik.repositories;

import be.multimedi.jammik.common.Categorie;
import be.multimedi.jammik.entities.Menu;
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
class MenuRepositoryTest {

    private MenuRepository mr;

    @Autowired
    public MenuRepositoryTest(MenuRepository mr) {
        this.mr = mr;
    }

    @Test
    void getById() {
        Menu menu = mr.getMenuById(1);
        assertNotNull(menu);
        assertEquals("Macaroni", menu.getMenuItems().get(1).getNaam());
    }

    @Test
    void findAll() {
        List<Menu> menus = mr.findAll();
        assertNotNull(menus);
        assertEquals(3, menus.size());
    }

    @Test
    void save() {
        Menu menu = new Menu(0, List.of(

                new MenuItem(0, "Aji de Gallina", 25.35f, "lekker gerechtje", Categorie.DESSERTEN),
                new MenuItem(0, "Patita con Mani", 15.58f, "lekker gerechtje", Categorie.DESSERTEN)
        ));

        menu = mr.save(menu);
        assertEquals(4, menu.getId());
    }

    @Test
    void deleteById() {
        mr.deleteById(2);
        assertEquals(2, mr.findAll().size());
    }
}
