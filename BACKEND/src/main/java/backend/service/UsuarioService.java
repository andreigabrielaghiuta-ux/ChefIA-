package backend.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import backend.dto.UsuarioRegistroDTO;
import backend.dto.UsuarioRespuestaDTO;
import backend.entity.Usuario;
import backend.repository.UsuarioRepository;

import java.util.Locale;

@Service 
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    
    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public UsuarioRespuestaDTO registrar(UsuarioRegistroDTO dto){
        String nombre = dto.getNombre().trim();
        String email = dto.getEmail().trim().toLowerCase(Locale.ROOT);
        if(usuarioRepository.existsByEmail(email)){
            throw new IllegalArgumentException("Este email ya existe");
        }


        String passwordHash = passwordEncoder.encode(dto.getPassword());

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setPasswordHash(passwordHash);

        Usuario usuarioGuardado = usuarioRepository.save(usuario);


        return new UsuarioRespuestaDTO(usuarioGuardado.getId(), usuarioGuardado.getNombre(), usuarioGuardado.getEmail(), usuarioGuardado.getFechaRegistro());
    }
}
