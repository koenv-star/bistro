package be.multimedi.jammik.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Gemaakt door: Michael Creelle

class MenuTest {
    private Menu menu;

    @BeforeEach
    void setUp() {
        menu = new Menu();
    }

    @Test
    void set_get_id() {
        int id = 5;
        menu.setId(id);
        assertEquals(id, menu.getId());
    }

    @Test
    void throw_exception_on_negative_id(){
        assertThrows(IllegalArgumentException.class, () -> menu.setId(-1));
    }

    @Test
    void throw_exception_on_0_id() {
        assertThrows(IllegalArgumentException.class, () -> menu.setId(0));
    }

    @Test
    void set_get_MenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem());
        menu.setMenuItems(menuItems);
        assertEquals(menuItems, menu.getMenuItems());
    }

    @Test
    void throws_exception_on_null_menuItems() {
        assertThrows(IllegalArgumentException.class, () -> menu.setMenuItems(null));
    }

    @Test
    void throws_exception_on_empty_list_menuItems() {
        assertThrows(IllegalArgumentException.class, () -> menu.setMenuItems(new ArrayList<>()));
    }
}