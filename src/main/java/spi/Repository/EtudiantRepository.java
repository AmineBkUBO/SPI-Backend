package spi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spi.Entity.Etudiant;

public interface EtudiantRepository extends JpaRepository<String, Etudiant> {
}
