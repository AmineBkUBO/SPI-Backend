package spi.Service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import spi.Entity.Enseignant;
import spi.Service.Interface.EnseignantService;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class EnseignantSerivceImpl implements EnseignantService {
    @Override
    public Enseignant createEnseignant(Enseignant enseignant) {
        return null;
    }

    @Override
    public List<Enseignant> getAllEnseignants() {
        return List.of();
    }

    @Override
    public Optional<Enseignant> getEnseignantById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Enseignant updateEnseignant(Enseignant enseignant) {
        return null;
    }
}
