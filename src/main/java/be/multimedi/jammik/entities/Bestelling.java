package be.multimedi.jammik.entities;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.List;

// Gemaakt door: Michael Creelle

@Entity
@Table(name = "Bestelling")
public class Bestelling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @NotNull
    @OneToMany
    @Column(name = "MenuItems")
    private List<MenuItem> menuItems;

    public void setId(int id) {
        if (id < 1) throw new IllegalArgumentException("id mag niet 0 of negatief zijn");
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        if (menuItems == null || menuItems.size() < 1) throw new IllegalArgumentException("menu items mag niet null of leeg zijn");
        this.menuItems = menuItems;
    }
}
