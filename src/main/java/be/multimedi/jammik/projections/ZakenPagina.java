package be.multimedi.jammik.projections;


import org.springframework.beans.factory.annotation.Value;

public interface ZakenPagina {
    int getId();
    String getNaam();
    String getImageURL();
    String getEmail();
    String getText();
}

