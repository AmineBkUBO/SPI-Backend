package spi.Exception;

public class EnseignantNotFoundException extends RuntimeException {
    public EnseignantNotFoundException(Integer id) {
        super("Enseignant with Id : " + id + " Does Not exist !");
    }
}
