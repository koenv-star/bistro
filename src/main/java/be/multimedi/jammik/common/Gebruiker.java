package be.multimedi.jammik.common;

import be.multimedi.jammik.entities.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * made by Koen
 */


public class Gebruiker implements UserDetails {


    private String naam;
    private String voornaam;
    private  String email;
    private String role;


    @JsonIgnore
    private String paswoord;

    public Gebruiker(Person person) {


        this.voornaam = person.getVoornaam();
        this.naam = person.getNaam();
        this.paswoord = person.getWachtwoord();
        this.email=person.getEmail();
        this.role=person.getRole();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(this.role));
    }

    @Override
    public String getPassword() {
        return paswoord;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
