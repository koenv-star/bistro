package be.multimedi.jammik;


import be.multimedi.jammik.entities.Klant;
import be.multimedi.jammik.repositories.KlantRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"be.multimedi.jammik.repositories"})
public class JammikApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(JammikApplication.class, args);
    }

    @Autowired
    private KlantRepository repo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {


//        Klant klant = new Klant();
//        System.out.println(encoder.encode("KoenVochten"));
//        klant.setWachtwoord(encoder.encode("KoenVochten"));
//        klant.setNaam("Vochten");
//        klant.setVoornaam("Koen");
//        repo.save(klant);


    }

}


