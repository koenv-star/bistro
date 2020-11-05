package be.multimedi.jammik.common;


/**
 * Made by Koen
 */
public enum Categorie {
    DESSERTEN("Desserten"),
    HOOFDGERECHTEN("Hoofdgerechten"),
    COCKTAILS("Cocktails"),
    FRISDRANKEN("frisdranken");

    private String naam;

    Categorie(String naam) {

        this.naam = naam;
    }
}
