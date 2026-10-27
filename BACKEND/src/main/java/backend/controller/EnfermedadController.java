package backend.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.dto.EnfermedadRespuestaDTO;
import backend.service.EnfermedadService;

@RestController
@RequestMapping("/api/enfermedades")
public class EnfermedadController {

    private final EnfermedadService enfermedadService;

    public EnfermedadController(EnfermedadService enfermedadService) {
        this.enfermedadService = enfermedadService;
    }

    @GetMapping
    public List<EnfermedadRespuestaDTO> listarEnfermedades() {
        return enfermedadService.listarEnfermedades();
    }

    @PostMapping("/{enfermedadId}")
    public EnfermedadRespuestaDTO añadirEnfermedad(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable Long enfermedadId) {

        Long usuarioId = Long.valueOf(jwt.getSubject());

        return enfermedadService.añadirEnfermedad(
                usuarioId,
                enfermedadId
        );
    }

    @DeleteMapping("/{enfermedadId}")
    public EnfermedadRespuestaDTO eliminarEnfermedad(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable Long enfermedadId) {

        Long usuarioId = Long.valueOf(jwt.getSubject());

        return enfermedadService.eliminarEnfermedad(
                usuarioId,
                enfermedadId
        );
    }

    @GetMapping("/mis-enfermedades")
    public List<EnfermedadRespuestaDTO> listarEnfermedadesUsuario(
            @AuthenticationPrincipal Jwt jwt) {

        Long usuarioId = Long.valueOf(jwt.getSubject());

        return enfermedadService.listarEnfermedadesUsuario(usuarioId);
    }
}