package spi.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spi.Entity.Promotion;
import spi.Exception.PromotionNotFoundException;
import spi.Repository.PromotionRepository;
import spi.Service.Interface.PromotionService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository promotionRepository;

    @Override
    public Promotion createPromotion(Promotion promotion) {
        log.info("Creating Promotion: {}", promotion.getSiglePro());
        return promotionRepository.save(promotion);
    }

    @Override
    public List<Promotion> getAllPromotions() {
        log.info("Fetching page of Promotions");
        return promotionRepository.findAll();
    }


    @Override
    public Optional<Promotion> getPromotionById(String id) {
        log.info("Fetching Promotion by id: {}", id);
        Optional<Promotion> promotion = promotionRepository.findById(id);
        if (promotion.isEmpty()) {
            log.warn("Promotion with id {} not found", id);
        }
        return promotion;
    }

    @Override
    public Promotion updatePromotion(Promotion promotion) {
        String anneePro = promotion.getAnneePro();
        log.info("Updating Promotion with anneePro {}", anneePro);

        Promotion existing = promotionRepository.findById(anneePro)
                .orElseThrow(() -> {
                    log.error("Promotion with anneePro {} not found", anneePro);
                    return new PromotionNotFoundException(anneePro);
                });

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

        Promotion updated = promotionRepository.save(existing);
        log.info("Updated Promotion with anneePro {}", anneePro);
        return updated;
    }
}
