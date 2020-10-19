package be.multimedi.jammik.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * Gemaakt door Jan
 */
@Entity
@Table(name="adres")
public class Adres {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Min(1)
    private int id;

    @NotBlank
    private String straat;

    @NotBlank
    private String huisNr;

    @Min(1000)
    @Max(9999)
    private int postcode;

    @NotBlank
    private String gemeente;

    public Adres() {
    }

    public Adres(int id, String straat, String huisNr, int postcode, String gemeente) {
        setId(id);
        setStraat(straat);
        setHuisNr(huisNr);
        setPostcode(postcode);
        setGemeente(gemeente);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id < 0)
            throw new IllegalArgumentException("id mag niet kleiner zijn dan 0");

        this.id = id;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        if(straat == null)
            throw new IllegalArgumentException("straat mag niet null zijn");

        this.straat = straat;
    }

    public String getHuisNr() {
        return huisNr;
    }

    public void setHuisNr(String huisNr) {
        if(huisNr == null)
            throw new IllegalArgumentException("huisNr mag niet null zijn");

        this.huisNr = huisNr;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        if(postcode < 1000 || postcode > 9999)
            throw new IllegalArgumentException("postcode moet tussen 1000 en 9999 liggen");

        this.postcode = postcode;
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setGemeente(String gemeente) {
        if(gemeente == null)
            throw new IllegalArgumentException("gemeente mag niet null zijn");

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