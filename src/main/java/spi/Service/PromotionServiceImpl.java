package spi.Service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import spi.Entity.Promotion;
import spi.Service.Interface.PromotionService;

import java.util.List;
import java.util.Optional;


@Transactional
@Service
public class PromotionServiceImpl implements PromotionService {
    @Override
    public Promotion createPromotion(Promotion promotion) {
        return null;
    }

    @Override
    public List<Promotion> getAllPromotions() {
        return List.of();
    }

    @Override
    public Optional<Promotion> getPromotionById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Promotion updatePromotion(Promotion promotion) {
        return null;
    }
}
