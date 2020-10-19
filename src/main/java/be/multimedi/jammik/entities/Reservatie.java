package be.multimedi.jammik.entities;

import javax.persistence.*;

@Entity
@Table(name="reservatie")
public class Reservatie {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
}