package backend.exception;

public class AlergiaNoEncontradaException extends RuntimeException {
    public AlergiaNoEncontradaException(Long alergiaId) {
        super("No existe una alergia con ese ID:  " + alergiaId + ".");
    }
}
