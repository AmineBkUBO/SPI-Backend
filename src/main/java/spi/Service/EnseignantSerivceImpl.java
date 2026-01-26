package spi.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import spi.Entity.Enseignant;
import spi.Entity.Etudiant;
import spi.Exception.EnseignantNotFoundException;
import spi.Exception.EtudiantNotFoundException;
import spi.Repository.EnseignantRepository;
import spi.Service.Interface.EnseignantService;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class EnseignantSerivceImpl implements EnseignantService {

    private final EnseignantRepository enseignantRepository;

    @Override
    public Enseignant createEnseignant(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }

    @Override
    public Page<Enseignant> getAllEnseignants(int page) {
        return enseignantRepository.findAll(PageRequest.of(page, 20));
    }

    @Override
    public Optional<Enseignant> getEnseignantById(Integer id) {
        return enseignantRepository.findById(id);
    }

    @Override
    public Enseignant updateEnseignant(Enseignant enseignant) {
        Integer id = enseignant.getId();

        Enseignant existing = enseignantRepository.findById(id)
                .orElseThrow(() -> new EnseignantNotFoundException(id));

        // 🔹 Basic info
        if (enseignant.getType() != null) existing.setType(enseignant.getType());
        if (enseignant.getSexe() != null) existing.setSexe(enseignant.getSexe());
        if (enseignant.getNom() != null) existing.setNom(enseignant.getNom());
        if (enseignant.getPrenom() != null) existing.setPrenom(enseignant.getPrenom());

        // 🔹 Address info
        if (enseignant.getAdresse() != null) existing.setAdresse(enseignant.getAdresse());
        if (enseignant.getCp() != null) existing.setCp(enseignant.getCp());
        if (enseignant.getVille() != null) existing.setVille(enseignant.getVille());
        if (enseignant.getPays() != null) existing.setPays(enseignant.getPays());

        // 🔹 Contact info
        if (enseignant.getTelPort() != null) existing.setTelPort(enseignant.getTelPort());
        if (enseignant.getEncPersoTel() != null) existing.setEncPersoTel(enseignant.getEncPersoTel());
        if (enseignant.getEncUboTel() != null) existing.setEncUboTel(enseignant.getEncUboTel());
        if (enseignant.getEncPersoEmail() != null) existing.setEncPersoEmail(enseignant.getEncPersoEmail());
        if (enseignant.getEncUboEmail() != null) existing.setEncUboEmail(enseignant.getEncUboEmail());

        // 🔹 Internal company info
        if (enseignant.getIntNoInsee() != null) existing.setIntNoInsee(enseignant.getIntNoInsee());
        if (enseignant.getIntSocNom() != null) existing.setIntSocNom(enseignant.getIntSocNom());
        if (enseignant.getIntSocAdresse() != null) existing.setIntSocAdresse(enseignant.getIntSocAdresse());
        if (enseignant.getIntSocCp() != null) existing.setIntSocCp(enseignant.getIntSocCp());
        if (enseignant.getIntSocVille() != null) existing.setIntSocVille(enseignant.getIntSocVille());
        if (enseignant.getIntSocPays() != null) existing.setIntSocPays(enseignant.getIntSocPays());
        if (enseignant.getIntFonction() != null) existing.setIntFonction(enseignant.getIntFonction());
        if (enseignant.getIntProfEmail() != null) existing.setIntProfEmail(enseignant.getIntProfEmail());
        if (enseignant.getIntProfTel() != null) existing.setIntProfTel(enseignant.getIntProfTel());

        // 🔹 Save and return updated entity
        return enseignantRepository.save(existing);
    }

}
