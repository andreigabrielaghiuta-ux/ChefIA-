package backend.controller;


import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.oauth2.jwt.Jwt;

import backend.dto.UsuarioRegistroDTO;
import backend.dto.UsuarioRespuestaDTO;
import backend.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public  UsuarioController (UsuarioService usuarioService) {
        this.usuarioService=usuarioService;  
    }

    @PostMapping("/registro")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioRespuestaDTO registrar(
            @Valid @RequestBody UsuarioRegistroDTO dto) {

        return usuarioService.registrar(dto);
    }

    @GetMapping ("/me")
    public UsuarioRespuestaDTO obtenerUsuarioActual(@AuthenticationPrincipal Jwt jwt){
        Long usuarioId = Long.valueOf(jwt.getSubject());
        return usuarioService.obtenerUsuario(usuarioId);
    }
}