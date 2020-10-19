package be.multimedi.jammik.klant;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Klanten")
public class Klant {

    @Id
    private int id;
    private String email;
    private String naam;
    private String voornaam;
    private String paswoord;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getPaswoord() {
        return paswoord;
    }

    public void setPaswoord(String paswoord) {
        this.paswoord = paswoord;
    }


}
