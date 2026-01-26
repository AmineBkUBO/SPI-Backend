package spi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spi.Entity.Enseignant;
import spi.Entity.Etudiant;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant , String> {
}
