package be.multimedi.jammik.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Mehmet van Team-B
 */
@Getter
@Setter
public class Inkom {
    private int zaakId;
    private String zaakNaam;

    private double totalEarning;



    public Inkom() {
    }

    public Inkom(int zaakId, String zaakNaam, double totalEarning) {
        this.zaakId = zaakId;
        this.zaakNaam = zaakNaam;
        this.totalEarning = totalEarning;
    }


}
