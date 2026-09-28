package backend.service;

import org.springframework.stereotype.Service;

import backend.dto.LoginRespuestaDTO;
import backend.dto.UsuarioLoginDTO;
import backend.entity.Usuario;
import backend.dto.UsuarioRespuestaDTO;


@Service 
public class AutenticacionService {
    private final UsuarioService usuarioService;
    private final TokenService tokenService;

    public AutenticacionService(UsuarioService usuarioService, TokenService tokenService){
        this.usuarioService=usuarioService;
        this.tokenService=tokenService;
    }

    public LoginRespuestaDTO login (UsuarioLoginDTO dto){
        Usuario usuario = usuarioService.autenticar(dto);
        String token = tokenService.generarToken(usuario);
        UsuarioRespuestaDTO usuarioRespuestaDTO = new UsuarioRespuestaDTO(usuario.getId(), usuario.getNombre(), usuario.getEmail(), usuario.getFechaRegistro());
        return new LoginRespuestaDTO(token, "Bearer", usuarioRespuestaDTO);
    }
    
}
