package be.multimedi.jammik.entities;

import javax.persistence.*;

/**
 * @author Mehmet van Team-B
 */
@Entity
@Table(name = "Advertenties")
public class Advertentie {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "ZaakNaam")
    private String zaakNaam;

    @Column(name = "ZaakId")
    private int zaakId;

    @Column(name = "Description")
    private String zaakDesc;

    @Column(name = "NumberShow")
    private int numberOfShow;


    public Advertentie() {
    }

    public Advertentie(String zaakNaam, String zaakDesc, int zaakId, int numberOfShow) {
        this.zaakNaam = zaakNaam;
        this.zaakDesc = zaakDesc;
        this.numberOfShow = numberOfShow;
        this.zaakId = zaakId;
    }

    public int getZaakId() {
        return zaakId;
    }

    public void setZaakId(int zaakId) {
        this.zaakId = zaakId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZaakNaam() {
        return zaakNaam;
    }

    public void setZaakNaam(String zaakNaam) {
        this.zaakNaam = zaakNaam;
    }

    public String getZaakDesc() {
        return zaakDesc;
    }

    public void setZaakDesc(String zaakDesc) {
        this.zaakDesc = zaakDesc;
    }

    public int getNumberOfShow() {
        return numberOfShow;
    }

    public void setNumberOfShow(int numberOfShow) {
        this.numberOfShow = numberOfShow;
    }
}
