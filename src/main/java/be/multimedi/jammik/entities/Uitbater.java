package be.multimedi.jammik.entities;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

// Gemaakt door: Michael Creelle

@Entity
@Table(name = "Uitbater")
public class Uitbater extends Person{
    @NotNull
    @OneToMany
    @Column(name = "Zaken")
    private List<Zaak> zaken;

    public List<Zaak> getZaken() {
        return zaken;
    }

    public void setZaken(List<Zaak> zaken) {
        if (zaken == null) throw new IllegalArgumentException("zaken mag niet null zijn");
        this.zaken = zaken;
    }
}
