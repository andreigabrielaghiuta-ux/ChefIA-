package backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.dto.LoginRespuestaDTO;
import backend.dto.UsuarioLoginDTO;
import backend.service.AutenticacionService;
import jakarta.validation.Valid;

@RestController 
@RequestMapping("/api/usuarios")
public class AutenticacionController {
    private final AutenticacionService autenticacionService;
    public AutenticacionController(AutenticacionService autenticacionService){
        this.autenticacionService=autenticacionService;
    }
    @PostMapping("/login")
    public LoginRespuestaDTO login(@Valid @RequestBody UsuarioLoginDTO dto){
    return autenticacionService.login(dto);
    }
}
