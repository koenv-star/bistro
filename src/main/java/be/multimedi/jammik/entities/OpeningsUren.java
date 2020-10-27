package be.multimedi.jammik.entities;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * Gemaakt door Jan
 */
@Entity
@Table(name="Openingsuren")
public class OpeningsUren {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Min(1)
    @Column(name="Id")
    private int id;

    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
    @JoinColumn(name = "openings_uren_id")
    private List<Dag> dagen;

    public OpeningsUren() {
    }

    public OpeningsUren(@Min(1) int id, List<Dag> dagen) {
        setId(id);
        setDagen(dagen);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id < 0) throw new IllegalArgumentException("id kan niet kleiner zijn dan 0");

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