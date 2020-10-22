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
    @Column(name="Id")
    private int id;

    @NotNull
    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
//    @Column(name = "MenuItems")
    private List<MenuItem> menuItems;

    public Menu() {
    }

    public Menu(int id, List<MenuItem> menuItems) {
        setId(id);
        setMenuItems(menuItems);
    }

    public void setId(int id) {
        if (id < 0) throw new IllegalArgumentException("id mag niet negatief zijn");
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
