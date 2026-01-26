package spi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spi.Entity.Etudiant;
import spi.Entity.Formation;

@Repository
public interface FormationRepository extends JpaRepository<Formation, String> {
}
