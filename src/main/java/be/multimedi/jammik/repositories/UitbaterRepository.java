package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Klant;
import be.multimedi.jammik.entities.Uitbater;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Gemaakt door Jan
 */
@Repository
public interface UitbaterRepository extends JpaRepository<Uitbater, String> {




}
