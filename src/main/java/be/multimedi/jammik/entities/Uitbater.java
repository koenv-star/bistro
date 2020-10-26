package be.multimedi.jammik.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

// Gemaakt door: Michael Creelle

@Entity
@Table(name = "Uitbater")
public class Uitbater extends Klant {

    @NotNull
    @OneToMany(mappedBy="uitbater", fetch= FetchType.LAZY, cascade=CascadeType.REMOVE)
    private List<Zaak> zaken;

    public Uitbater() {
    }

    @Override
    public String getRole() {
        return "ROLE_UITBATER";
    }

    public Uitbater(@Email String email, String naam, String voornaam, String wachtwoord, double krediet,
                   List<Reservatie> reservaties, List<BestellingVerzameling> bestellingVerzamelingen , List<Zaak> zaken) {

        super(email, naam, voornaam, wachtwoord, krediet, reservaties, bestellingVerzamelingen);
        setZaken(zaken);
    }

    public List<Zaak> getZaken() {
        return zaken;
    }

    public void setZaken(List<Zaak> zaken) {
        if (zaken == null) throw new IllegalArgumentException("zaken mag niet null zijn");
        this.zaken = zaken;
    }

    @Override
    public String getRole() {
        return "ROLE_UITBATER";
    }
}
