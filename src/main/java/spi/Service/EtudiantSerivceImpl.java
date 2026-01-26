package spi.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import spi.Entity.Etudiant;
import spi.Exception.EtudiantNotFoundException;
import spi.Repository.EtudiantRepository;
import spi.Service.Interface.EtudiantService;
import org.springframework.data.domain.Page;


import java.util.List;
import java.util.Optional;


@Transactional
@Service
@RequiredArgsConstructor
public class EtudiantSerivceImpl implements EtudiantService {

    private final EtudiantRepository etudiantRepository;

    @Override
    public Etudiant createEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Page<Etudiant> getEtudiants(int page) {
        return etudiantRepository.findAll(PageRequest.of(page, 20));
    }


    @Override
    public Optional<Etudiant> getEtudiantById(String noEtudNat) {
        return etudiantRepository.getEtudiantByNoEtudiantNat( noEtudNat);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {

        String id = etudiant.getNoEtudiantNat();

        Etudiant existing = etudiantRepository.findById(id)
                .orElseThrow(() ->
                        new EtudiantNotFoundException(id)
                );

        // 🔹 Relations
        existing.setAnneePro(etudiant.getAnneePro());

        // 🔹 Identity / personal info
        existing.setNom(etudiant.getNom());
        existing.setPrenom(etudiant.getPrenom());
        existing.setSexe(etudiant.getSexe());
        existing.setDateNaissance(etudiant.getDateNaissance());
        existing.setLieuNaissance(etudiant.getLieuNaissance());
        existing.setNationalite(etudiant.getNationalite());

        // 🔹 Academic info
        existing.setSituation(etudiant.getSituation());
        existing.setDernierDiplome(etudiant.getDernierDiplome());
        existing.setUniversite(etudiant.getUniversite());
        existing.setSigleEtu(etudiant.getSigleEtu());
        existing.setCompteCri(etudiant.getCompteCri());
        existing.setEstDiplome(etudiant.getEstDiplome());

        // 🔹 Contact info
        existing.setEmail(etudiant.getEmail());
        existing.setUboEmail(etudiant.getUboEmail());
        existing.setTelPort(etudiant.getTelPort());
        existing.setTelFixe(etudiant.getTelFixe());


        existing.setActuAdresse(etudiant.getActuAdresse());
        existing.setActuCp(etudiant.getActuCp());
        existing.setActuVille(etudiant.getActuVille());
        existing.setActuPays(etudiant.getActuPays());

        existing.setPermAdresse(etudiant.getPermAdresse());
        existing.setPermCp(etudiant.getPermCp());
        existing.setPermVille(etudiant.getPermVille());
        existing.setPermPays(etudiant.getPermPays());

        // 🔹 Misc
        existing.setCodeCom(etudiant.getCodeCom());
        existing.setNoEtudiantUbo(etudiant.getNoEtudiantUbo());
        existing.setGrpeAnglais(etudiant.getGrpeAnglais());
        existing.setAbandonMotif(etudiant.getAbandonMotif());
        existing.setAbandonDate(etudiant.getAbandonDate());

        // No need to call save() explicitly, but it's fine to be explicit
        return etudiantRepository.save(existing);
    }
}
