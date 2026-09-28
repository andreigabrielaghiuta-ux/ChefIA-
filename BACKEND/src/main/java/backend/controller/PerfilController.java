package backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/{usuarioId}/perfil")
    @ResponseStatus(HttpStatus.CREATED)
    public PerfilRespuestaDTO crearPerfil(@PathVariable Long usuarioId, @Valid @RequestBody PerfilRegistroDTO  dto) {

        return perfilService.crearPerfil(usuarioId, dto);
    }
}