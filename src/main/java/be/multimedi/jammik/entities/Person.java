package be.multimedi.jammik.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;

import static be.multimedi.jammik.tools.StringTool.validEmail;


// Gemaakt door: Michael Creelle

@MappedSuperclass
public abstract class Person {

    @Id
    @NotNull
    @Email
    @Column(name="Email")
    protected String email;

    @NotNull
    @Column(name = "Naam")
    protected String naam;

    @NotNull
    @Column(name = "Voornaam")
    protected String voornaam;

    @NotNull
    @JsonIgnore
    @Column(name = "Wachtwoord")
    protected String wachtwoord;

    @NotNull
    @Column(name = "Krediet")
    protected double krediet;

    public Person() {
    }

    public Person(@Email String email, String naam, String voornaam, String wachtwoord, double krediet) {
        setEmail(email);
        setNaam(naam);
        setVoornaam(voornaam);
        setWachtwoord(wachtwoord);
        setKrediet(krediet);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !validEmail(email)) throw new IllegalArgumentException("email mag niet null zijn en moet valid email zijn");
        this.email = email;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if (naam == null || naam.isBlank() || naam.length() > 25) throw new IllegalArgumentException("naam mag niet null of leeg of langer dan 25 characters zijn");
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        if (voornaam == null || voornaam.isBlank() || voornaam.length() > 25) throw new IllegalArgumentException("voornaam mag niet null of leeg of langer dan 25 characters zijn");
        this.voornaam = voornaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        if (wachtwoord == null || wachtwoord.length() != 72) throw new IllegalArgumentException("wachtwoord mag niet null of moet 72 characters lang zijn");
        this.wachtwoord = wachtwoord;
    }

    public double getKrediet() {
        return krediet;
    }

    public void setKrediet(double krediet) {
        if (krediet < 0) throw new IllegalArgumentException("krediet mag niet negatief zijn");
        this.krediet = krediet;
    }
}
