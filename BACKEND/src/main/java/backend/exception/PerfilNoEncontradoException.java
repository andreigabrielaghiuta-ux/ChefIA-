package backend.exception;

public class PerfilNoEncontradoException extends RuntimeException {
    public PerfilNoEncontradoException(Long usuarioId) {
        super("El usuario con ID:  " + usuarioId + " aún no tiene perfil.");
    }
}
