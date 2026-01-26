package spi.Service.Interface;

import spi.Entity.Etudiant;

import java.util.List;
import java.util.Optional;

public interface EtudiantService {

    Etudiant createEtudiant(Etudiant etudiant);

    List<Etudiant> getAllEtudiants();
    Optional<Etudiant> getEtudiantById(Integer id);

    Etudiant updateEtudiant(Etudiant etudiant);
}
