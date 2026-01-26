package spi.Service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import spi.Entity.Etudiant;
import spi.Service.Interface.EtudiantService;

import java.util.List;
import java.util.Optional;


@Transactional
@Service
public class EtudiantSerivceImpl implements EtudiantService {
    @Override
    public Etudiant createEtudiant(Etudiant etudiant) {
        return null;
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return List.of();
    }

    @Override
    public Optional<Etudiant> getEtudiantById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        return null;
    }
}
