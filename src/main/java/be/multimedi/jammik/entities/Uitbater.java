package be.multimedi.jammik.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;
import java.util.Optional;

// Gemaakt door: Michael Creelle

@Entity
@Table(name = "Uitbater")
public class Uitbater extends Klant {

    @NotNull
    @OneToMany(mappedBy="uitbater", cascade=CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
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
//        if (zaken == null) throw new IllegalArgumentException("zaken mag niet null zijn");
        this.zaken = zaken;
    }

}
