package spi.Exception;

public class FormationNotFoundException extends RuntimeException {
    public FormationNotFoundException(Integer id) {
        super("Promotion with Id : " + id + " Does Not exist !");
    }
}
