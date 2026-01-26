package spi.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import spi.Entity.Etudiant;
import spi.Exception.EtudiantNotFoundException;
import spi.Repository.EtudiantRepository;
import spi.Service.Interface.EtudiantService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class EtudiantSerivceImpl implements EtudiantService {

    private final EtudiantRepository etudiantRepository;

    @Override
    public Etudiant createEtudiant(Etudiant etudiant) {
        log.info("Creating Etudiant: {} {}", etudiant.getNom(), etudiant.getPrenom());
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> getEtudiants() {
        log.info("Fetching page of Etudiants");
        return etudiantRepository.findAll();
    }

    @Override
    public Optional<Etudiant> getEtudiantById(String noEtudNat) {
        log.info("Fetching Etudiant by id: {}", noEtudNat);
        Optional<Etudiant> etudiant = etudiantRepository.getEtudiantByNoEtudiantNat(noEtudNat);
        if (etudiant.isEmpty()) {
            log.warn("Etudiant with id {} not found", noEtudNat);
        }
        return etudiant;
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        String id = etudiant.getNoEtudiantNat();
        log.info("Updating Etudiant with id {}", id);

        Etudiant existing = etudiantRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Etudiant with id {} not found", id);
                    return new EtudiantNotFoundException(id);
                });

        // PATCH update: only non-null fields
        if (etudiant.getAnneePro() != null) existing.setAnneePro(etudiant.getAnneePro());
        if (etudiant.getNom() != null) existing.setNom(etudiant.getNom());
        if (etudiant.getPrenom() != null) existing.setPrenom(etudiant.getPrenom());
        if (etudiant.getSexe() != null) existing.setSexe(etudiant.getSexe());
        if (etudiant.getDateNaissance() != null) existing.setDateNaissance(etudiant.getDateNaissance());
        if (etudiant.getLieuNaissance() != null) existing.setLieuNaissance(etudiant.getLieuNaissance());
        if (etudiant.getNationalite() != null) existing.setNationalite(etudiant.getNationalite());
        if (etudiant.getSituation() != null) existing.setSituation(etudiant.getSituation());
        if (etudiant.getDernierDiplome() != null) existing.setDernierDiplome(etudiant.getDernierDiplome());
        if (etudiant.getUniversite() != null) existing.setUniversite(etudiant.getUniversite());
        if (etudiant.getSigleEtu() != null) existing.setSigleEtu(etudiant.getSigleEtu());
        if (etudiant.getCompteCri() != null) existing.setCompteCri(etudiant.getCompteCri());
        if (etudiant.getEstDiplome() != null) existing.setEstDiplome(etudiant.getEstDiplome());
        if (etudiant.getEmail() != null) existing.setEmail(etudiant.getEmail());
        if (etudiant.getUboEmail() != null) existing.setUboEmail(etudiant.getUboEmail());
        if (etudiant.getTelPort() != null) existing.setTelPort(etudiant.getTelPort());
        if (etudiant.getTelFixe() != null) existing.setTelFixe(etudiant.getTelFixe());
        if (etudiant.getActuAdresse() != null) existing.setActuAdresse(etudiant.getActuAdresse());
        if (etudiant.getActuCp() != null) existing.setActuCp(etudiant.getActuCp());
        if (etudiant.getActuVille() != null) existing.setActuVille(etudiant.getActuVille());
        if (etudiant.getActuPays() != null) existing.setActuPays(etudiant.getActuPays());
        if (etudiant.getPermAdresse() != null) existing.setPermAdresse(etudiant.getPermAdresse());
        if (etudiant.getPermCp() != null) existing.setPermCp(etudiant.getPermCp());
        if (etudiant.getPermVille() != null) existing.setPermVille(etudiant.getPermVille());
        if (etudiant.getPermPays() != null) existing.setPermPays(etudiant.getPermPays());
        if (etudiant.getCodeCom() != null) existing.setCodeCom(etudiant.getCodeCom());
        if (etudiant.getNoEtudiantUbo() != null) existing.setNoEtudiantUbo(etudiant.getNoEtudiantUbo());
        if (etudiant.getGrpeAnglais() != null) existing.setGrpeAnglais(etudiant.getGrpeAnglais());
        if (etudiant.getAbandonMotif() != null) existing.setAbandonMotif(etudiant.getAbandonMotif());
        if (etudiant.getAbandonDate() != null) existing.setAbandonDate(etudiant.getAbandonDate());

        Etudiant updated = etudiantRepository.save(existing);
        log.info("Updated Etudiant with id {}", id);
        return updated;
    }
}
