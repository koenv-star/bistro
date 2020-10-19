package be.multimedi.jammik.entities;


import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;

// Gemaakt door: Michael Creelle

@Entity
public class Dag {

    @Id
    @NotNull
    @Column(name = "naam")
    private String naam;

    @NotNull
    @Column(name = "OpeningsUur")
    private Time openingsUur;

    @NotNull
    @Column(name = "SluitingsUur")
    private Time sluitingsUur;

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if (naam == null || naam.isBlank()) throw new IllegalArgumentException("Naam mag niet null of leeg zijn");
        this.naam = naam;
    }

    public Time getOpeningsUur() {
        return openingsUur;
    }

    public void setOpeningsUur(Time openingsUur) {
        if (openingsUur == null) throw new IllegalArgumentException("OpeningsUur mag niet null zijn");
        this.openingsUur = openingsUur;
    }

    public Time getSluitingsUur() {
        return sluitingsUur;
    }

    public void setSluitingsUur(Time sluitingsUur) {
        if (sluitingsUur == null) throw new IllegalArgumentException("SluitingsUur mag niet null zijn");
        this.sluitingsUur = sluitingsUur;
    }
}
