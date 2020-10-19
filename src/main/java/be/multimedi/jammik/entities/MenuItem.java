package be.multimedi.jammik.entities;


import com.sun.istack.NotNull;

import javax.persistence.*;

// Created by: Michael Creelle

@Entity
@Table(name = "MenuItem")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "Naam")
    private String naam;

    @NotNull
    @Column(name = "Prijs")
    private float prijs;

    public void setId(int id) {
        if(id < 1) throw new IllegalArgumentException("id mag niet 0 of negatief zijn");
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
