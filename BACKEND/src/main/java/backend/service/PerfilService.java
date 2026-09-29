package backend.service;

import org.springframework.stereotype.Service;

import backend.dto.PerfilRegistroDTO;
import backend.dto.PerfilRespuestaDTO;
import backend.entity.Perfil;
import backend.entity.Usuario;
import backend.exception.PerfilNoEncontradoException;
import backend.exception.PerfilYaExisteException;
import backend.exception.UsuarioNoEncontradoException;
import backend.repository.PerfilRepository;
import backend.repository.UsuarioRepository;

@Service 
public class PerfilService {
    
    private  final PerfilRepository perfilRepository;
    private final UsuarioRepository usuarioRepository;
    
    public PerfilService(PerfilRepository perfilRepository, UsuarioRepository usuarioRepository){
        this.perfilRepository=perfilRepository;
        this.usuarioRepository=usuarioRepository;
    }

    public PerfilRespuestaDTO  crearPerfil (Long usuarioId, PerfilRegistroDTO dto){
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new UsuarioNoEncontradoException(usuarioId));
        if (perfilRepository.existsByUsuarioId(usuarioId)){
            throw new PerfilYaExisteException(usuarioId);
        }

        Perfil perfil = new Perfil(dto.getAltura(),dto.getPeso(),dto.getFechaNacimiento(),dto.getNivelActividad(),dto.getSexo(),dto.getObjetivo(),usuario);
        Perfil perfilGuardado = perfilRepository.save(perfil);
        return new PerfilRespuestaDTO(perfilGuardado.getId(),perfilGuardado.getAltura(),perfilGuardado.getPeso(),perfilGuardado.getFechaNacimiento(),perfilGuardado.getNivelActividad(),perfilGuardado.getSexo(),perfilGuardado.getObjetivo());
    }

    public PerfilRespuestaDTO obtenerPerfil(Long usuarioId){
        Perfil perfil = perfilRepository.findByUsuarioId(usuarioId).orElseThrow(() -> new PerfilNoEncontradoException(usuarioId));
        return new PerfilRespuestaDTO(perfil.getId(), perfil.getAltura(), perfil.getPeso(), perfil.getFechaNacimiento(),perfil.getNivelActividad(),perfil.getSexo(),perfil.getObjetivo());
    }

    public PerfilRespuestaDTO actualizarPerfil(Long usuarioId, PerfilRegistroDTO dto){
    Perfil perfil = perfilRepository.findByUsuarioId(usuarioId).orElseThrow(() -> new PerfilNoEncontradoException(usuarioId));
    perfil.setAltura(dto.getAltura());
    perfil.setPeso(dto.getPeso());
    perfil.setFechaNacimiento(dto.getFechaNacimiento());
    perfil.setNivelActividad(dto.getNivelActividad());
    perfil.setSexo(dto.getSexo());
    perfil.setObjetivo(dto.getObjetivo());
    Perfil perfilGuardado = perfilRepository.save(perfil);
    return new PerfilRespuestaDTO(perfilGuardado.getId(),perfilGuardado.getAltura(),perfilGuardado.getPeso(),perfilGuardado.getFechaNacimiento(),perfilGuardado.getNivelActividad(),perfilGuardado.getSexo(),perfilGuardado.getObjetivo());
    }
}
