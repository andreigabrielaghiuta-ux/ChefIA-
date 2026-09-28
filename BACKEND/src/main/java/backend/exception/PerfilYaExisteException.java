package backend.exception;

public class PerfilYaExisteException extends RuntimeException{
    public PerfilYaExisteException(Long usuarioId){
        super("Este usuario con ID: "+usuarioId+" ya tiene un perfil.");
    }
}
