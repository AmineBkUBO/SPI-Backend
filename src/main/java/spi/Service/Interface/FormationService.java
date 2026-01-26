package spi.Service.Interface;

import org.springframework.data.domain.Page;
import spi.Entity.Formation;

import java.util.List;
import java.util.Optional;

public interface FormationService {

    Formation createFormation(Formation formation);

    List<Formation> getAllFormations();
    Optional<Formation> getFormationById(String id);

    Formation updateFormation(Formation formation);
}
