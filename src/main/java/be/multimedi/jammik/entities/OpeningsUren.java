package be.multimedi.jammik.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * Gemaakt door Jan
 */
@Entity
@Table(name="openingsuren")
public class OpeningsUren {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Min(1)
    private int id;

    @OneToMany(mappedBy="openingsUur", fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
    private List<Dag> dagen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id < 1) throw new IllegalArgumentException("id kan niet kleiner zijn dan 1");

        this.id = id;
    }

    public List<Dag> getDagen() {
        return dagen;
    }

    public void setDagen(List<Dag> dagen) {
        if(dagen == null) throw new IllegalArgumentException("dagen kan niet null zijn");

        this.dagen = dagen;
    }

    @Override
    public String toString() {
        return "OpeningsUren{" +
                "id=" + id +
                ", dagen=" + dagen +
                '}';
    }
}