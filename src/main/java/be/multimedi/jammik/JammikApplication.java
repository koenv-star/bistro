package be.multimedi.jammik;

import be.multimedi.jammik.repositories.AdresRepository;
import be.multimedi.jammik.repositories.MenuItemRepository;
import be.multimedi.jammik.repositories.TafelRepository;
import be.multimedi.jammik.repositories.ZaakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"be.multimedi.jammik.repositories"})
public class JammikApplication implements CommandLineRunner {

	@Autowired
	TafelRepository tafelRepository;

	@Autowired
	ZaakRepository zaakRepository;

	@Autowired
	AdresRepository adresRepository;

	@Autowired
	MenuItemRepository menuItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(JammikApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(tafelRepository);
	}
}
