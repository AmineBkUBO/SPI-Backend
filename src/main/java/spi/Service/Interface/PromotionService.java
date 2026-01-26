package spi.Service.Interface;

import spi.Entity.Promotion;

import java.util.List;
import java.util.Optional;

public interface PromotionService {

    Promotion createPromotion(Promotion promotion);

    List<Promotion> getAllPromotions();
    Optional<Promotion> getPromotionById(Integer id);

    Promotion updatePromotion(Promotion promotion);
}
