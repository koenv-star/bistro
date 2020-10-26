package be.multimedi.jammik.entities;

import javax.persistence.*;

import javax.validation.constraints.Email;
import java.util.List;

// Gemaakt door: Michael Creelle

@Entity
@Table(name = "Klant")
public class Klant extends Person {


    public Klant() {
    }

    public Klant(@Email String email, String naam, String voornaam, String wachtwoord, double krediet,
                 List<Reservatie> reservaties, List<BestellingVerzameling> bestellingVerzamelingen) {

        super(email, naam, voornaam, wachtwoord, krediet);
        setReservaties(reservaties);
        setBestellingVerzamelingen(bestellingVerzamelingen);
    }

    public String getRole() {
        return  "ROLE_KLANT";
    }
}
