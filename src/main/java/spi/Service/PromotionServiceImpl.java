package spi.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import spi.Entity.Promotion;
import spi.Exception.PromotionNotFoundException;
import spi.Repository.PromotionRepository;
import spi.Service.Interface.PromotionService;

import java.util.List;
import java.util.Optional;


@Transactional
@Service
@RequiredArgsConstructor
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository promotionRepository;

    @Override
    public Promotion createPromotion(Promotion promotion) {

        return promotionRepository.save(promotion);
    }

    @Override
    public Page<Promotion> getAllPromotions(int page) {

        return promotionRepository.findAll(PageRequest.of(page, 20));
    }

    @Override
    public Optional<Promotion> getPromotionById(String id) {

        return promotionRepository.findById(id);
    }

    @Override
    public Promotion updatePromotion(Promotion promotion) {
        String anneePro = promotion.getAnneePro();

        // 1️⃣ Find existing promotion or throw exception
        Promotion existing = promotionRepository.findById(anneePro)
                .orElseThrow(() -> new PromotionNotFoundException(anneePro));

        // 2️⃣ Update only non-null fields (PATCH semantics)
        if (promotion.getCodeFormation() != null) existing.setCodeFormation(promotion.getCodeFormation());
        if (promotion.getNoEnseignant() != null) existing.setNoEnseignant(promotion.getNoEnseignant());
        if (promotion.getSiglePro() != null) existing.setSiglePro(promotion.getSiglePro());
        if (promotion.getNbEtuSouhaite() != null) existing.setNbEtuSouhaite(promotion.getNbEtuSouhaite());
        if (promotion.getEtatPreselection() != null) existing.setEtatPreselection(promotion.getEtatPreselection());
        if (promotion.getDateRentree() != null) existing.setDateRentree(promotion.getDateRentree());
        if (promotion.getLieuRentree() != null) existing.setLieuRentree(promotion.getLieuRentree());
        if (promotion.getDateReponseLp() != null) existing.setDateReponseLp(promotion.getDateReponseLp());
        if (promotion.getCommentaire() != null) existing.setCommentaire(promotion.getCommentaire());
        if (promotion.getDateReponseLalp() != null) existing.setDateReponseLalp(promotion.getDateReponseLalp());
        if (promotion.getProcessusStage() != null) existing.setProcessusStage(promotion.getProcessusStage());
        if (promotion.getNoEvaluation() != null) existing.setNoEvaluation(promotion.getNoEvaluation());
        if (promotion.getNoBareme() != null) existing.setNoBareme(promotion.getNoBareme());

        // 3️⃣ Save and return the updated entity
        return promotionRepository.save(existing);
    }

}
