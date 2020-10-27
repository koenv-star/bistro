package be.multimedi.jammik.entities;


import com.sun.istack.NotNull;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import javax.validation.constraints.Min;

// Gemaakt door: Michael Creelle

@Entity
@Table(name = "MenuItem")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    @Column(name="Id")
    private int id;

    @NotNull
    @Column(name = "Naam")
    private String naam;

    @NotNull
    @Column(name = "Prijs")
    private float prijs;

    public MenuItem() {
    }

    public MenuItem(@Min(1) int id, String naam, float prijs) {
        setId(id);
        setNaam(naam);
        setPrijs(prijs);
    }

    public void setId(int id) {
        if(id < 0) throw new IllegalArgumentException("id mag niet negatief zijn");
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if(naam == null || naam.isBlank()) throw new IllegalArgumentException("naam mag niet leeg zijn of null");
        this.naam = naam;
    }

    public float getPrijs() {
        return prijs;
    }

    public void setPrijs(float prijs) {
        if (prijs < 0) throw new IllegalArgumentException("prijs mag niet negatief zijn");
        this.prijs = prijs;
    }
}
