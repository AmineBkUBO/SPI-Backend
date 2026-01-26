package spi.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import spi.Entity.Enseignant;
import spi.Exception.EnseignantNotFoundException;
import spi.Repository.EnseignantRepository;
import spi.Service.Interface.EnseignantService;

import java.util.Optional;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class EnseignantSerivceImpl implements EnseignantService {

    private final EnseignantRepository enseignantRepository;

    @Override
    public Enseignant createEnseignant(Enseignant enseignant) {
        log.info("Creating new Enseignant: {}", enseignant.getNom());
        return enseignantRepository.save(enseignant);
    }

    @Override
    public Page<Enseignant> getAllEnseignants() {
        log.info("Fetching page of Enseignants");
        return enseignantRepository.findAll();
    }

    @Override
    public Optional<Enseignant> getEnseignantById(Integer id) {
        log.info("Fetching Enseignant by id: {}", id);
        Optional<Enseignant> enseignant = enseignantRepository.findById(id);
        if (enseignant.isEmpty()) {
            log.warn("Enseignant with id {} not found", id);
        }
        return enseignant;
    }

    @Override
    public Enseignant updateEnseignant(Enseignant enseignant) {
        Integer id = enseignant.getId();
        log.info("Updating Enseignant with id {}", id);

        Enseignant existing = enseignantRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Enseignant with id {} not found", id);
                    return new EnseignantNotFoundException(id);
                });

        // PATCH-like update: only non-null fields
        if (enseignant.getType() != null) existing.setType(enseignant.getType());
        if (enseignant.getSexe() != null) existing.setSexe(enseignant.getSexe());
        if (enseignant.getNom() != null) existing.setNom(enseignant.getNom());
        if (enseignant.getPrenom() != null) existing.setPrenom(enseignant.getPrenom());
        if (enseignant.getAdresse() != null) existing.setAdresse(enseignant.getAdresse());
        if (enseignant.getCp() != null) existing.setCp(enseignant.getCp());
        if (enseignant.getVille() != null) existing.setVille(enseignant.getVille());
        if (enseignant.getPays() != null) existing.setPays(enseignant.getPays());
        if (enseignant.getTelPort() != null) existing.setTelPort(enseignant.getTelPort());
        if (enseignant.getEncPersoTel() != null) existing.setEncPersoTel(enseignant.getEncPersoTel());
        if (enseignant.getEncUboTel() != null) existing.setEncUboTel(enseignant.getEncUboTel());
        if (enseignant.getEncPersoEmail() != null) existing.setEncPersoEmail(enseignant.getEncPersoEmail());
        if (enseignant.getEncUboEmail() != null) existing.setEncUboEmail(enseignant.getEncUboEmail());
        if (enseignant.getIntNoInsee() != null) existing.setIntNoInsee(enseignant.getIntNoInsee());
        if (enseignant.getIntSocNom() != null) existing.setIntSocNom(enseignant.getIntSocNom());
        if (enseignant.getIntSocAdresse() != null) existing.setIntSocAdresse(enseignant.getIntSocAdresse());
        if (enseignant.getIntSocCp() != null) existing.setIntSocCp(enseignant.getIntSocCp());
        if (enseignant.getIntSocVille() != null) existing.setIntSocVille(enseignant.getIntSocVille());
        if (enseignant.getIntSocPays() != null) existing.setIntSocPays(enseignant.getIntSocPays());
        if (enseignant.getIntFonction() != null) existing.setIntFonction(enseignant.getIntFonction());
        if (enseignant.getIntProfEmail() != null) existing.setIntProfEmail(enseignant.getIntProfEmail());
        if (enseignant.getIntProfTel() != null) existing.setIntProfTel(enseignant.getIntProfTel());

        Enseignant updated = enseignantRepository.save(existing);
        log.info("Updated Enseignant with id {}", id);
        return updated;
    }
}
