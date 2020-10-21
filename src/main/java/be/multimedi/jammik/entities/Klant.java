package be.multimedi.jammik.entities;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.util.List;

// Gemaakt door: Michael Creelle

@Entity
@Table(name = "Klant")
public class Klant extends Person {

    @NotNull
    @OneToMany
    @Column(name = "Reservaties")
    private List<Reservatie> reservaties;

    @NotNull
    @OneToMany
    @Column(name = "BestellingVerzamelingen")
    private List<BestellingVerzameling> bestellingVerzamelingen;

    public Klant() {
    }

    public Klant(@Email String email, String naam, String voornaam, String wachtwoord, int krediet,
                 List<Reservatie> reservaties, List<BestellingVerzameling> bestellingVerzamelingen) {

        super(email, naam, voornaam, wachtwoord, krediet);
        setReservaties(reservaties);
        setBestellingVerzamelingen(bestellingVerzamelingen);
    }

    public List<Reservatie> getReservaties() {
        return reservaties;
    }

    public void setReservaties(List<Reservatie> reservaties) {
        if(reservaties == null) throw new IllegalArgumentException("reservaties mag niet null zijn");
        this.reservaties = reservaties;
    }

    public List<BestellingVerzameling> getBestellingVerzamelingen() {
        return bestellingVerzamelingen;
    }

    public void setBestellingVerzamelingen(List<BestellingVerzameling> bestellingVerzamelingen) {
        if (bestellingVerzamelingen == null) throw new IllegalArgumentException("bestellingverzamelingen mag niet null zijn");
        this.bestellingVerzamelingen = bestellingVerzamelingen;
    }
}
