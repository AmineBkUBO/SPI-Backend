package spi.Exception;

public class PromotionNotFoundException extends RuntimeException {
    public PromotionNotFoundException(Integer id) {
        super("Promotion with Id : " + id + " Does Not exist !");
    }
}
