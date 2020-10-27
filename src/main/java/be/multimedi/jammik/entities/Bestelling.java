package be.multimedi.jammik.entities;

import com.sun.istack.NotNull;
import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

// Gemaakt door: Michael Creelle

@Entity
@Table(name = "Bestelling")
public class Bestelling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    @Column(name="Id")
    private int id;

    @NotNull
    @ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
    @JoinTable(name = "Bestelling_MenuItems",
            joinColumns = {@JoinColumn(name = "bestelling_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "menu_item_id", referencedColumnName = "id")})
    private List<MenuItem> menuItems;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Zaak zaak;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bestelling_verzameling_id")
    private BestellingVerzameling bestellingVerzameling;

    public Bestelling() {
    }

    public Bestelling(@Min(1) int id, List<MenuItem> menuItems, Zaak zaak) {
        setId(id);
        setMenuItems(menuItems);
        setZaak(zaak);
    }

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

    public Zaak getZaak() {
        return zaak;
    }

    public void setZaak(Zaak zaak) {
        if (zaak == null) throw new IllegalArgumentException("zaak mag niet null zijn");
        this.zaak = zaak;
    }
}
