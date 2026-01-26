package spi.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import spi.Entity.Formation;
import spi.Exception.FormationNotFoundException;
import spi.Repository.FormationRepository;
import spi.Service.Interface.FormationService;

import java.util.List;
import java.util.Optional;


@Transactional
@Service
@RequiredArgsConstructor
public class FormationSerivceImpl implements FormationService {

    private final FormationRepository formationRepository;

    @Override
    public Formation createFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    @Override
    public Page<Formation> getAllFormations(int page) {
        return formationRepository.findAll(PageRequest.of(page, 20));
    }

    @Override
    public Optional<Formation> getFormationById(String id) {

        return formationRepository.findById(id);
    }

    @Override
    public Formation updateFormation(Formation formation) {
        String code = formation.getCodeFormation();

        // 1️⃣ Find existing formation or throw exception
        Formation existing = formationRepository.findById(code)
                .orElseThrow(() -> new FormationNotFoundException(code));

        // 2️⃣ Update only non-null fields (PATCH semantics)
        if (formation.getDiplome() != null) existing.setDiplome(formation.getDiplome());
        if (formation.getN0Annee() != null) existing.setN0Annee(formation.getN0Annee());
        if (formation.getNomFormation() != null) existing.setNomFormation(formation.getNomFormation());
        if (formation.getDoubleDiplome() != null) existing.setDoubleDiplome(formation.getDoubleDiplome());
        if (formation.getDebutHabilitation() != null) existing.setDebutHabilitation(formation.getDebutHabilitation());
        if (formation.getFinHabilitation() != null) existing.setFinHabilitation(formation.getFinHabilitation());

        // 3️⃣ Save and return the updated entity
        return formationRepository.save(existing);
    }

}
