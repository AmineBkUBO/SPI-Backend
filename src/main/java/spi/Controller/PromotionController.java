package spi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spi.Entity.Promotion;
import spi.Service.Interface.PromotionService;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/promotions")
@RequiredArgsConstructor
public class PromotionController {

    private final PromotionService promotionService;

    @PostMapping
    public ResponseEntity<Promotion> create(@RequestBody Promotion promotion) {
        return ResponseEntity.ok(promotionService.createPromotion(promotion));
    }

    @GetMapping
    public ResponseEntity<List<Promotion>> getAll() {
        return ResponseEntity.ok(promotionService.getAllPromotions());
    }

    @GetMapping("/{anneePro}")
    public ResponseEntity<Promotion> getById(@PathVariable String anneePro) {
        Optional<Promotion> promotion = promotionService.getPromotionById(anneePro);
        return promotion.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{anneePro}")
    public ResponseEntity<Promotion> update(@PathVariable String anneePro,
                                            @RequestBody Promotion promotion) {
        promotion.setAnneePro(anneePro);
        return ResponseEntity.ok(promotionService.updatePromotion(promotion));
    }
}
