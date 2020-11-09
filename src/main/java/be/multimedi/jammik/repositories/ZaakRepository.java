package be.multimedi.jammik.repositories;

import be.multimedi.jammik.entities.Zaak;
import be.multimedi.jammik.projections.ZakenPagina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Gemaakt door Jan
 */
@Repository
public interface ZaakRepository extends JpaRepository<Zaak, Integer> {

    default Zaak getZaakById(int id) {
        return getOne(id);
    }
    Optional<List<Zaak>> findZaaksByEmail(String email);
    Optional<Zaak> findZaakByNaam(String naam);
    <T> List<T> findAllBy(Class<T> type);
    List<ZakenPagina> findAllByEmail(String email);
}
