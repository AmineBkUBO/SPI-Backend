package spi.Exception;

public class EtudiantNotFoundException extends RuntimeException{
    public EtudiantNotFoundException(String id) {
        super("Etudiant with Id : " + id + " Does Not exist !");
    }
}
