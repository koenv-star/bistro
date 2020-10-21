package be.multimedi.jammik.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

// Gemaakt door: Michael Creelle

@Entity
@Table(name = "Tafel")
public class Tafel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @NotNull
    @Column(name = "Stoelen")
    private int stoelen;

    public Tafel() {
    }

    public Tafel(int id, int stoelen) {
        setId(id);
        setStoelen(stoelen);
    }

    public void setId(int id) {
        if (id < 0) throw new IllegalArgumentException("id mag niet 0 of negatief zijn");
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setStoelen(int stoelen) {
        if (stoelen < 1) throw new IllegalArgumentException("stoelen mag niet 1 of negatief zijn");
        this.stoelen = stoelen;
    }

    public int getStoelen() {
        return stoelen;
    }

}
