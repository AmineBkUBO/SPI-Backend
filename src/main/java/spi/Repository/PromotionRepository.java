package spi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spi.Entity.Etudiant;

public interface PromotionRepository extends JpaRepository<String, Etudiant> {
}
