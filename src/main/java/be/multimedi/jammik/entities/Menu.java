package be.multimedi.jammik.entities;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.List;

// Gemaakt door: Michael Creelle

@Entity
@Table(name = "Menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        if (menuItems == null || menuItems.size() < 1) throw new IllegalArgumentException("MenuItems mag niet null of leeg zijn");
        this.menuItems = menuItems;
    }
}
