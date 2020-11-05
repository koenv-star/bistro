package be.multimedi.jammik.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Gemaakt door Jan
 */
@Entity
@Table(name="Reservatie")
public class Reservatie {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Min(0)
    @Column(name="Id")
    private int id;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Future
    @Column(name="Tijdstip")
    private LocalDateTime tijdstip;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name="UurMarge")
    private LocalTime uurMarge;

    @ManyToOne
    @JoinColumn(name = "Klant_Email", referencedColumnName = "Email")
    @NotNull
    private Klant klant;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Zaak_Id", referencedColumnName="Id")
    @NotNull
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    private Zaak zaak;

    @OneToOne
    @JoinColumn(name="Tafel_Id", referencedColumnName="Id")
    @NotNull
    private Tafel tafel;

    public Reservatie() {
    }

    public Reservatie(@Min(0) int id, @Future LocalDateTime tijdstip, LocalTime uurMarge, @NotNull Klant klant,
                      @NotNull Zaak zaak, @NotNull Tafel tafel) {
        setId(id);
        setTijdstip(tijdstip);
        setUurMarge(uurMarge);
        setKlant(klant);
        setZaak(zaak);
        setTafel(tafel);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id < 0) throw new IllegalArgumentException("id mag niet kleiner zijn dan 0");
        this.id = id;
    }

    public LocalDateTime getTijdstip() {
        return tijdstip;
    }

    public void setTijdstip(LocalDateTime wanneer) {
        if(wanneer == null) throw new IllegalArgumentException("wanneer kan niet null zijn");
        if(wanneer.isBefore(LocalDateTime.now())) throw new IllegalArgumentException("wanneer moet in de toekomst liggen");

        this.tijdstip = wanneer;
    }

    public LocalTime getUurMarge() {
        return uurMarge;
    }

    public void setUurMarge(LocalTime uurMarge) {
        if(uurMarge == null) throw new IllegalArgumentException("uurMarge kan niet null zijn");
        this.uurMarge = uurMarge;
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
                ", wanneer=" + tijdstip +
                ", uurMarge=" + uurMarge +
                ", klant=" + klant +
                ", zaak=" + zaak +
                ", tafel=" + tafel +
                '}';
    }
}
