package be.multimedi.jammik.entities;

import com.sun.istack.NotNull;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.*;
import javax.validation.constraints.Min;

// Gemaakt door: Michael Creelle

@Entity
@Table(name = "Bestelling")
public class Bestelling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(0)
    @Column(name = "Id")
    private int id;

    @NotNull
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToOne
    private MenuItem menuItem;

    @Min(1)
    @Column(name = "Aantal")
    private int aantal;

    @NotNull
    @Min(1)
    @Column(name = "zaak_Id")
    private int zaakId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bestelling_verzameling_id")
    private BestellingVerzameling bestellingVerzameling;

    public Bestelling() {
    }

    public Bestelling(@Min(0) int id, MenuItem menuItem, int aantal, int zaakId) {
        setId(id);
        setMenuItem(menuItem);
        setAantal(aantal);
        setZaakId(zaakId);
    }


    public void setId(int id) {
        if (id < 0) throw new IllegalArgumentException("id mag niet kleiner zijn dan 0");
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        if (menuItem == null ) throw new IllegalArgumentException("menuItem mag niet null of leeg zijn");
        this.menuItem = menuItem;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        if (aantal < 0) throw new IllegalArgumentException("aantal moet groter dan 0 zijn");
        this.aantal = aantal;
    }

    public int getZaakId() {
        return zaakId;
    }

    public void setZaakId(int zaakId) {
        if(zaakId < 1) throw new IllegalArgumentException("zaak id mag niet onder 1 zijn");
        this.zaakId = zaakId;
    }

    public BestellingVerzameling getBestellingVerzameling() {
        return bestellingVerzameling;
    }

    public void setBestellingVerzameling(BestellingVerzameling bestellingVerzameling) {
        if (bestellingVerzameling == null)
            throw new IllegalArgumentException("Bestellingverzameling mag niet null zijn");
        this.bestellingVerzameling = bestellingVerzameling;
    }
}
