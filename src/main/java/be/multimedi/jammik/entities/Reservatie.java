package be.multimedi.jammik.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static be.multimedi.jammik.tools.DateTimeTool.*;

/**
 * Gemaakt door Jan
 */
@Entity
@Table(name="reservatie")
public class Reservatie {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Min(1)
    private int id;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Future
    private LocalDateTime wanneer;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalTime uurMarge;

    @Min(0)
    @Digits(integer=3, fraction=2)
    private double totaal;

    @ManyToOne
    @Column(name="klant_id")
    @NotNull
    private Klant klant;

    @OneToOne
    @Column(name="zaak_id")
    @NotNull
    private Zaak zaak;

    @OneToOne
    @Column(name="tafel_id")
    @NotNull
    private Tafel tafel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id < 0)
            throw new IllegalArgumentException("id mag niet kleiner zijn dan 0");

        this.id = id;
    }

    public LocalDateTime getWanneer() {
        return wanneer;
    }

    public void setWanneer(LocalDateTime wanneer) {
        if(wanneer == null) throw new IllegalArgumentException("wanneer kan niet null zijn");
        if(wanneer.isBefore(LocalDateTime.now())) throw new IllegalArgumentException("wanneer moet in de toekomst liggen");

        this.wanneer = wanneer;
    }

    public LocalTime getUurMarge() {
        return uurMarge;
    }

    public void setUurMarge(LocalTime uurMarge) {
        if(uurMarge == null) throw new IllegalArgumentException("uurMarge kan niet null zijn");
        this.uurMarge = uurMarge;
    }

    public double getTotaal() {
        return totaal;
    }

    public void setTotaal(double totaal) {
        if(totaal < 0) throw new IllegalArgumentException("totaal kan niet kleiner dan 0 zijn");
        if(!String.valueOf(totaal).matches("^[\\d]+\\.([\\d]|[\\d]{2})$"))
            throw new IllegalArgumentException("totaal moet twee getallen na de komma hebben");

        this.totaal = totaal;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        if(klant == null) throw new IllegalArgumentException("klant kan niet null zijn");

        this.klant = klant;
    }

    public Zaak getZaak() {
        return zaak;
    }

    public void setZaak(Zaak zaak) {
        if(zaak == null) throw new IllegalArgumentException("zaak kan niet null zijn");

        this.zaak = zaak;
    }

    public Tafel getTafel() {
        return tafel;
    }

    public void setTafel(Tafel tafel) {
        if(tafel == null) throw new IllegalArgumentException("tafel kan niet null zijn");

        this.tafel = tafel;
    }

    @Override
    public String toString() {
        return "Reservatie{" +
                "id=" + id +
                ", wanneer=" + wanneer +
                ", uurMarge=" + uurMarge +
                ", totaal=" + totaal +
                ", klant=" + klant +
                ", zaak=" + zaak +
                ", tafel=" + tafel +
                '}';
    }
}