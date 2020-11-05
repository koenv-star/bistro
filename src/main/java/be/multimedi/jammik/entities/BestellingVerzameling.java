package be.multimedi.jammik.entities;

import com.sun.istack.NotNull;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

// Gemaakt door: Michael Creelle

@Entity
@Table(name = "BestellingVerzameling")
public class BestellingVerzameling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(0)
    @Column(name="Id")
    private int id;

    @NotNull
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade=CascadeType.PERSIST, mappedBy = "bestellingVerzameling")
    private List<Bestelling> bestellingen;


    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Klant_Email", referencedColumnName = "Email")
    private Klant klant;

    public BestellingVerzameling() {
    }

    public BestellingVerzameling(@Min(0) int id, List<Bestelling> bestellingen) {
        setId(id);
        setBestellingen(bestellingen);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) throw new IllegalArgumentException("id mag niet negatief zijn");
        this.id = id;
    }

    public List<Bestelling> getBestellingen() {
        return bestellingen;
    }

    public void setBestellingen(List<Bestelling> bestellingen) {
        if (bestellingen == null || bestellingen.size() < 1) throw new IllegalArgumentException("bestellingen mag niet null of leeg zijn");
        this.bestellingen = bestellingen;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        if (klant == null) throw new IllegalArgumentException("klant mag niet null zijn");
        this.klant = klant;
    }
}
