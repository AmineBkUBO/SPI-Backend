package spi.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import spi.Entity.Formation;
import spi.Exception.FormationNotFoundException;
import spi.Repository.FormationRepository;
import spi.Service.Interface.FormationService;

import java.util.Optional;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class FormationSerivceImpl implements FormationService {

    private final FormationRepository formationRepository;

    @Override
    public Formation createFormation(Formation formation) {
        log.info("Creating Formation: {}", formation.getNomFormation());
        return formationRepository.save(formation);
    }

    @Override
    public Page<Formation> getAllFormations(int page) {
        log.info("Fetching page {} of Formations", page);
        return formationRepository.findAll(PageRequest.of(page, 20));
    }

    @Override
    public Optional<Formation> getFormationById(String id) {
        log.info("Fetching Formation by id: {}", id);
        Optional<Formation> formation = formationRepository.findById(id);
        if (formation.isEmpty()) {
            log.warn("Formation with id {} not found", id);
        }
        return formation;
    }

    @Override
    public Formation updateFormation(Formation formation) {
        String code = formation.getCodeFormation();
        log.info("Updating Formation with code {}", code);

        Formation existing = formationRepository.findById(code)
                .orElseThrow(() -> {
                    log.error("Formation with code {} not found", code);
                    return new FormationNotFoundException(code);
                });

        if (formation.getDiplome() != null) existing.setDiplome(formation.getDiplome());
        if (formation.getN0Annee() != null) existing.setN0Annee(formation.getN0Annee());
        if (formation.getNomFormation() != null) existing.setNomFormation(formation.getNomFormation());
        if (formation.getDoubleDiplome() != null) existing.setDoubleDiplome(formation.getDoubleDiplome());
        if (formation.getDebutHabilitation() != null) existing.setDebutHabilitation(formation.getDebutHabilitation());
        if (formation.getFinHabilitation() != null) existing.setFinHabilitation(formation.getFinHabilitation());

        Formation updated = formationRepository.save(existing);
        log.info("Updated Formation with code {}", code);
        return updated;
    }
}
