package backend.exception;

public class EnfermedadNoEncontradaException extends RuntimeException {
    public EnfermedadNoEncontradaException(Long enfermedadId) {
        super("No existe una enfermedad con ese ID:  " + enfermedadId + ".");
    }
}