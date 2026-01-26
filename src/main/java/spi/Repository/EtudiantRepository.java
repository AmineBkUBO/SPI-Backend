package spi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spi.Entity.Etudiant;

import java.util.Optional;


@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant , String> {
    Optional<Etudiant> getEtudiantByNoEtudiantNat(String noEtudiantNat);
}
