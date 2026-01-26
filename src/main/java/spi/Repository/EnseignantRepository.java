package spi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spi.Entity.Enseignant;
import spi.Entity.Etudiant;

import java.util.Optional;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant , Integer> {
    Optional<Enseignant> getEnseignantById(Integer id);
}
