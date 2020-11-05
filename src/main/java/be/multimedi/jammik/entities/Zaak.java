package be.multimedi.jammik.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import java.util.List;

// Gemaakt door: Michael Creelle

@Entity
@Table(name = "Zaak")
public class Zaak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(0)
    @Column(name = "Id")
    private int id;

    @NotNull
    @Min(2)
    @Column(name = "Naam")
    private String naam;

    @NotNull
    @Column(name = "Description")
    private String description;

    @NotNull
    @Column(name = "ImageURL")
    private String imageURL;

    @Column(name = "Parking")
    private boolean parking;

    @Min(0)
    @Max(5)
    @Column(name = "Rating")
    private float rating;

    @NotNull
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "Openingsuren_Id", referencedColumnName = "Id")
    private OpeningsUren openingsUren;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Adres_Id", referencedColumnName = "Id")
    private Adres adres;

    @NotNull
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "Menu_Id", referencedColumnName = "Id")
    private Menu menu;

//    @NotNull
//    @ManyToOne(cascade=CascadeType.ALL)
//    @JoinColumn(name = "Uitbater_Email", referencedColumnName = "Email")
//    @JsonIdentityInfo(
//            generator = ObjectIdGenerators.PropertyGenerator.class,
//            property = "email", scope=Uitbater.class)
//    private Uitbater uitbater;

    @NotNull
    @Column(name="Uitbater_Email")
    private String email;

    @NotNull
    @OneToMany(cascade=CascadeType.PERSIST)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "zaak_id")
    private List<Tafel> tafels;

    @NotNull
    @OneToMany(mappedBy = "zaak", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    private List<Reservatie> reservaties;

    @NotNull
    @OneToMany(cascade = CascadeType.DETACH)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JoinColumn(name = "zaak_id")
    private List<Bestelling> bestellingen;

    public Zaak() {
    }

    public Zaak(@Min(0) int id, @Min(2) String naam, boolean parking, @Min(0) @Max(5) float rating,
                OpeningsUren openingsUren, Adres adres, Menu menu, String email, List<Tafel> tafels,
                List<Reservatie> reservaties) {
        setId(id);
        setNaam(naam);
        setParking(parking);
        setRating(rating);
        setOpeningsUren(openingsUren);
        setAdres(adres);
        setMenu(menu);
        setEmail(email);
        setTafels(tafels);
        setReservaties(reservaties);
    }

    public void setId(int id) {
        if (id < 0) throw new IllegalArgumentException("id mag niet kleiner zijn dan 0");
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if (naam == null) throw new IllegalArgumentException("naam kan niet null zijn");

        this.naam = naam;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null) throw new IllegalArgumentException("description mag niet null zijn");
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        if (imageURL == null) throw new IllegalArgumentException("img url mag niet null zijn");
        this.imageURL = imageURL;
    }

    public boolean isParking() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null) throw new IllegalArgumentException("email mag niet null zijn");
        this.email = email;
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

    public List<Bestelling> getBestellingen() {
        return bestellingen;
    }

    public void setBestellingen(List<Bestelling> bestellingen) {
        if (bestellingen == null) throw new IllegalArgumentException("bestellingen mag niet null zijn");
        this.bestellingen = bestellingen;
    }

    @Override
    public String toString() {
        return "Zaak{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                ", parking=" + parking +
                ", rating=" + rating +
                ", openingsUren=" + openingsUren +
                ", adres=" + adres +
                ", menu=" + menu +
                ", email=" + email +
                ", tafels=" + tafels +
                ", reservaties=" + reservaties +
                ", bestellingen=" + bestellingen +
                '}';
    }
}
