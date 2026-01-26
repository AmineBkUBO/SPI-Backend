package spi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spi.Entity.Etudiant;

public interface FormationRepository extends JpaRepository<String, Etudiant> {
}
