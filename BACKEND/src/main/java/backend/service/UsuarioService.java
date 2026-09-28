package backend.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import backend.dto.UsuarioLoginDTO;
import backend.dto.UsuarioRegistroDTO;
import backend.dto.UsuarioRespuestaDTO;
import backend.entity.Usuario;
import backend.exception.CredencialesInvalidasException;
import backend.exception.EmailYaRegistradoException;
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
            throw new EmailYaRegistradoException(email);
        }


        String passwordHash = passwordEncoder.encode(dto.getPassword());

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setPasswordHash(passwordHash);

        Usuario usuarioGuardado = usuarioRepository.save(usuario);


        return new UsuarioRespuestaDTO(usuarioGuardado.getId(), usuarioGuardado.getNombre(), usuarioGuardado.getEmail(), usuarioGuardado.getFechaRegistro());
    }
    public Usuario autenticar(UsuarioLoginDTO dto){
        String email = dto.getEmail().trim().toLowerCase(Locale.ROOT);
        String password = dto.getPassword();
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new CredencialesInvalidasException());
        boolean passwordCoincide = passwordEncoder.matches(password, usuario.getPasswordHash());
        
        if(!passwordCoincide){
            throw new CredencialesInvalidasException();
        }else{
           return usuario;
        }
    }
}
