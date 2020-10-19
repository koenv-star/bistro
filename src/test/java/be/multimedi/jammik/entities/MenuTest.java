package be.multimedi.jammik.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    void set_get_MenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem());
        menu.setMenuItems(menuItems);
        assertEquals(menuItems, menu.getMenuItems());
    }
}