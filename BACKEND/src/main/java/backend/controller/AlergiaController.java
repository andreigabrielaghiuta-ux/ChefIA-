package backend.controller;

import java.util.List;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.dto.AlergiaRespuestaDTO;
import backend.service.AlergiaService;

@RestController 
@RequestMapping ("/api/alergias")
public class AlergiaController {
    private final AlergiaService alergiaService;
        public AlergiaController(AlergiaService alergiaService){
            this.alergiaService=alergiaService;
        }
        @GetMapping 
        public List<AlergiaRespuestaDTO> listarAlergias(){
            return alergiaService.listarAlergias();
        }
        @PutMapping("/alergias")
        public AlergiaRespuestaDTO añadirAlergia(@AuthenticationPrincipal Jwt jwt, @PathVariable Long alergiaId) {
        Long usuarioId = Long.valueOf(jwt.getSubject());
        return alergiaService.añadirAlergia(usuarioId, alergiaId);
    }
        @DeleteMapping ("/{alergiaId}")
        public AlergiaRespuestaDTO eleminarAlergia(@AuthenticationPrincipal Jwt jwt, @PathVariable Long alergiaId) {
        Long usuarioId = Long.valueOf(jwt.getSubject());
        return alergiaService.eliminarAlergia(usuarioId, alergiaId);
    }

}
