package be.multimedi.jammik.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MenuItemTest {
    private MenuItem menuItem;

    @BeforeEach
    void setUp() {
        menuItem = new MenuItem();
    }

    @Test
    void set_get_id() {
        int id = 5;
        menuItem.setId(id);
        assertEquals(id, menuItem.getId());
    }

    @Test
    void throw_on_negative_id(){
        assertThrows(IllegalArgumentException.class, () -> menuItem.setId(-1));
    }

    @Test
    void throw_on_0_id() {
        assertThrows(IllegalArgumentException.class, () -> menuItem.setId(0));
    }

    @Test
    void set_get_naam() {
        String cola = "cola";
        menuItem.setNaam(cola);
        assertEquals(cola, menuItem.getNaam());
    }

    @Test
    void throw_on_null_naam() {
        assertThrows(IllegalArgumentException.class, () -> menuItem.setNaam(null));
    }

    @Test
    void throw_on_empty_string_naam() {
        assertThrows(IllegalArgumentException.class, () -> menuItem.setNaam(""));
    }

    @Test
    void set_get_prijs() {
        float prijs = 12.53f;
        menuItem.setPrijs(prijs);
        assertEquals(prijs, menuItem.getPrijs());
    }

    @Test
    void throw_on_negatieve_prijs(){
        assertThrows(IllegalArgumentException.class, () -> menuItem.setPrijs(-1f));
    }
}