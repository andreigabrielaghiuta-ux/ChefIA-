package backend.dto;

public class LoginRespuestaDTO {
    private String token;
    private String tipoToken;
    private UsuarioRespuestaDTO usuario;

    // ---CONSTRUCTORES--- //

    public LoginRespuestaDTO(){
    }
    public LoginRespuestaDTO(String token, String tipoToken, UsuarioRespuestaDTO usuario){
        this.token=token;
        this.tipoToken=tipoToken;
        this.usuario=usuario;
    }

    // ---GETTERS--- //

    public String getToken(){
        return token;
    }
    public String getTipoToken(){
        return tipoToken;
    }
    public UsuarioRespuestaDTO getUsuario(){
        return usuario;
    }

}
