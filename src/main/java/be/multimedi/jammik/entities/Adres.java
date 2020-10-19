package be.multimedi.jammik.entities;

import javax.persistence.*;

/**
 * Gemaakt door Jan
 */
@Entity
@Table(name="adres")
public class Adres {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String straat;
    private String huisNr;
    private int postcode;
    private String gemeente;

    public Adres() {
    }

    public Adres(int id, String straat, String huisNr, int postcode, String gemeente) {
        this.id = id;
        this.straat = straat;
        this.huisNr = huisNr;
        this.postcode = postcode;
        this.gemeente = gemeente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getHuisNr() {
        return huisNr;
    }

    public void setHuisNr(String huisNr) {
        this.huisNr = huisNr;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "id=" + id +
                ", straat='" + straat + '\'' +
                ", huisNr='" + huisNr + '\'' +
                ", postcode=" + postcode +
                ", gemeente='" + gemeente + '\'' +
                '}';
    }
}