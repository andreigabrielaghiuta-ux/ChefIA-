package backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
}