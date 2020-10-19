package be.multimedi.jammik.entities;

import com.sun.istack.NotNull;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import java.util.List;

// Gemaakt door: Michael Creelle

@Entity
public class Zaak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean parking;

    @Min(0)
    @Max(5)
    private float rating;

    @NotNull
    @OneToOne
    private OpeningsUren openingsUren;

    @NotNull
    @OneToOne
    private Adres adres;

    @NotNull
    @OneToOne
    private Menu menu;

    @NotNull
    @OneToOne
    private Uitbater uitbater;

    @NotNull
    @OneToMany
    private List<Tafel> tafels;

    @NotNull
    @OneToMany
    private List<Reservatie> reservaties;

    public void setId(int id) {
        if (id < 1) throw new IllegalArgumentException("id mag niet 0 of negatief zijn");
        this.id = id;
    }

    public int getId() {
        return id;
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
        if (rating < 0 || rating > 5) throw new IllegalArgumentException("rating mag ni negatief of meer dan 5 zijn");
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
