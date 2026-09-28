package backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;

import backend.dto.PerfilRegistroDTO;
import backend.dto.PerfilRespuestaDTO;
import backend.service.PerfilService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class PerfilController {

    private final PerfilService perfilService;

    public  PerfilController (PerfilService perfilService) {
        this.perfilService = perfilService;  
    }

    @PostMapping("/perfil")
    @ResponseStatus(HttpStatus.CREATED)
    public PerfilRespuestaDTO crearPerfil(@AuthenticationPrincipal Jwt jwt,@Valid @RequestBody PerfilRegistroDTO dto) {
    Long usuarioId = Long.valueOf(jwt.getSubject());
    return perfilService.crearPerfil(usuarioId, dto);
}
}