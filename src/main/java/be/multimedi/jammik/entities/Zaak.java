package be.multimedi.jammik.entities;

import com.sun.istack.NotNull;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import java.util.List;

// Gemaakt door: Michael Creelle

@Entity
@Table(name="Zaak")
public class Zaak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @NotNull
    @Min(2)
    @Column(name="Naam")
    private String naam;

    @Column(name="Parking")
    private boolean parking;

    @Min(0)
    @Max(5)
    @Column(name="Rating")
    private float rating;

    @NotNull
    @OneToOne
    @Column(name="openingsuren_id")
    private OpeningsUren openingsUren;

    @NotNull
    @OneToOne
    @Column(name="adres_id")
    private Adres adres;

    @NotNull
    @OneToOne
    @Column(name="menu_id")
    private Menu menu;

    @NotNull
    @OneToOne
    @Column(name="uitbater_id")
    private Uitbater uitbater;

    @NotNull
    @OneToMany
    @Column(name="Tafels")
    private List<Tafel> tafels;

    @NotNull
    @OneToMany
    @Column(name="Reservaties")
    private List<Reservatie> reservaties;

    public void setId(int id) {
        if (id < 0) throw new IllegalArgumentException("id mag niet 0 of negatief zijn");
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if(naam == null) throw new IllegalArgumentException("naam kan niet null zijn");

        this.naam = naam;
    }

    public boolean heeftParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        if (rating < 0 || rating > 5) throw new IllegalArgumentException("rating mag niet negatief of meer dan 5 zijn");
        this.rating = rating;
    }

    public OpeningsUren getOpeningsUren() {
        return openingsUren;
    }

    public void setOpeningsUren(OpeningsUren openingsUren) {
        if (openingsUren == null) throw new IllegalArgumentException("OpeningsUren mag niet null zijn");
        this.openingsUren = openingsUren;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        if (adres == null) throw new IllegalArgumentException("adres mag niet null zijn");
        this.adres = adres;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        if (menu == null) throw new IllegalArgumentException("menu mag niet null zijn");
        this.menu = menu;
    }

    public Uitbater getUitbater() {
        return uitbater;
    }

    public void setUitbater(Uitbater uitbater) {
        if (uitbater == null) throw new IllegalArgumentException("uitbater mag niet null zijn");
        this.uitbater = uitbater;
    }

    public List<Tafel> getTafels() {
        return tafels;
    }

    public void setTafels(List<Tafel> tafels) {
        if (tafels == null) throw new IllegalArgumentException("tafels mag niet null zijn");
        this.tafels = tafels;
    }

    public List<Reservatie> getReservaties() {
        return reservaties;
    }

    public void setReservaties(List<Reservatie> reservaties) {
        if (reservaties == null) throw new IllegalArgumentException("reservaties mag niet null zijn");
        this.reservaties = reservaties;
    }
}
