package spi.Service.Interface;

import org.springframework.data.domain.Page;
import spi.Entity.Enseignant;

import java.util.Optional;

public interface EnseignantService {

    Enseignant createEnseignant(Enseignant enseignant);

    Page<Enseignant> getAllEnseignants(int page);
    Optional<Enseignant> getEnseignantById(Integer id);

    Enseignant updateEnseignant(Enseignant enseignant);
}
