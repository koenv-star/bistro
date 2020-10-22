package be.multimedi.jammik;

import be.multimedi.jammik.entities.Dag;
import be.multimedi.jammik.repositories.DagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalTime;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"be.multimedi.jammik.repositories"})
public class JammikApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(JammikApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
