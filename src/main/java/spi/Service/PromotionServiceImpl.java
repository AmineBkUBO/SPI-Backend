package spi.Service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import spi.Service.Interface.PromotionService;



@Transactional
@Service
public class PromotionServiceImpl implements PromotionService {
}
