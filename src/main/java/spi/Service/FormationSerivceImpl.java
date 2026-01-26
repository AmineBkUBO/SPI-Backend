package spi.Service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import spi.Entity.Formation;
import spi.Service.Interface.FormationService;

import java.util.List;
import java.util.Optional;


@Transactional
@Service
public class FormationSerivceImpl implements FormationService {
    @Override
    public Formation createFormation(Formation formation) {
        return null;
    }

    @Override
    public List<Formation> getAllFormations() {
        return List.of();
    }

    @Override
    public Optional<Formation> getFormationById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Formation updateFormation(Formation formation) {
        return null;
    }
}
