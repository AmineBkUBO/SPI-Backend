package spi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spi.Entity.Etudiant;

public interface EnseignantRepository extends JpaRepository<String, Etudiant> {
}
