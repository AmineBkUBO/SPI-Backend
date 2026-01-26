package spi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spi.Entity.Etudiant;
import spi.Entity.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion , String> {
}
