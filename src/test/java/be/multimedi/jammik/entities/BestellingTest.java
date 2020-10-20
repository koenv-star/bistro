package be.multimedi.jammik.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Gemaakt door: Michael Creelle

class BestellingTest {

    private Bestelling bestelling;

    @BeforeEach
    void setUp() {
        bestelling = new Bestelling();
    }

    @Test
    void set_get_id() {
        int id = 5;
        bestelling.setId(id);
        assertEquals(id, bestelling.getId());
    }

    @Test
    void throw_exception_on_negative_id(){
        assertThrows(IllegalArgumentException.class, () -> bestelling.setId(-1));
    }

    @Test
    void throw_exception_on_0_id() {
        assertThrows(IllegalArgumentException.class, () -> bestelling.setId(0));
    }

    @Test
    void set_get_MenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem());
        bestelling.setMenuItems(menuItems);
        assertEquals(menuItems, bestelling.getMenuItems());
    }

    @Test
    void throws_exception_on_null_menuItems() {
        assertThrows(IllegalArgumentException.class, () -> bestelling.setMenuItems(null));
    }

    @Test
    void throws_exception_on_empty_list_menuItems() {
        assertThrows(IllegalArgumentException.class, () -> bestelling.setMenuItems(new ArrayList<>()));
    }
}