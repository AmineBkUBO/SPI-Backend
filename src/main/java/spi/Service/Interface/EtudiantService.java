package spi.Service.Interface;

import org.springframework.data.domain.Page;
import spi.Entity.Etudiant;

import java.util.List;
import java.util.Optional;

public interface EtudiantService {

    Etudiant createEtudiant(Etudiant etudiant);

    Page<Etudiant> getEtudiants(int page);
    Optional<Etudiant> getEtudiantById(String id);

    Etudiant updateEtudiant(Etudiant etudiant);
}
