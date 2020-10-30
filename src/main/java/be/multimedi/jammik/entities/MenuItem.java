package be.multimedi.jammik.entities;


import be.multimedi.jammik.common.Categorie;
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
    @Min(0)
    @Column(name = "Id")
    private int id;

    @NotNull
    @Column(name = "Naam")
    private String naam;

    @NotNull
    @Column(name = "Prijs")
    private float prijs;

    @NotNull
    @Column(name = "Beschrijving")
    private String beschrijving;

    @NotNull
    @Column(name = "Categorie")
    private Categorie categorie;


    public String getBeschrijving() {
        return beschrijving;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public MenuItem() {
    }

    public void setBeschrijving(String beschrijving) {
        if (beschrijving == null || beschrijving.isBlank())
            throw new IllegalArgumentException("beschrjving mag niet leeg zijn of null");
        this.beschrijving = beschrijving;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public MenuItem(@Min(0) int id, String naam, float prijs, String beschrijving, Categorie categorie) {
        setId(id);
        setNaam(naam);
        setPrijs(prijs);
        setBeschrijving(beschrijving);
        setCategorie(categorie);

    }

    public void setId(int id) {
        if (id < 0) throw new IllegalArgumentException("id mag niet kleiner zijn dan 0");
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if (naam == null || naam.isBlank()) throw new IllegalArgumentException("naam mag niet leeg zijn of null");
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
