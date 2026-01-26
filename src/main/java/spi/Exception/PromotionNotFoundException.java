package spi.Exception;

public class PromotionNotFoundException extends RuntimeException {
    public PromotionNotFoundException(String id) {
        super("Promotion with Id : " + id + " Does Not exist !");
    }
}
