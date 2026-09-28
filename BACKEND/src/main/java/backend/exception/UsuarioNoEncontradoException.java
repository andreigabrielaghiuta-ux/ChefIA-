package backend.exception;

public class UsuarioNoEncontradoException extends RuntimeException{
    public UsuarioNoEncontradoException(Long usuarioId){
        super("El usuario con este ID: "+usuarioId+" no existe.");
    }
}
