package be.multimedi.jammik;

import be.multimedi.jammik.klant.Klant;
import be.multimedi.jammik.repository.KlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
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


        Klant klant = new Klant();
        klant.setPaswoord(encoder.encode("KoenVochten"));
        klant.setNaam("Vochten");
        klant.setVoornaam("Koen");
        repo.save(klant);


    }
}


