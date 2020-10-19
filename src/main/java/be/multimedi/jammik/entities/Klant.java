package be.multimedi.jammik.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Gemaakt door: Michael Creelle

@Entity
@Table(name = "Klant")
public class Klant extends Person {

    public void setId(String id) {
        this.email = id;
    }

    @Id
    public String getId() {
        return email;
    }
}
