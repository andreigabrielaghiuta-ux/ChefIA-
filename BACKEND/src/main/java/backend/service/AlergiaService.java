package backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import backend.dto.AlergiaRespuestaDTO;
import backend.entity.Alergia;
import backend.entity.Perfil;
import backend.exception.AlergiaNoEncontradaException;
import backend.exception.PerfilNoEncontradoException;
import backend.repository.AlergiaRepository;
import backend.repository.PerfilRepository;

@Service 
public class AlergiaService {
    
    private final AlergiaRepository alergiaRepository;
    private final PerfilRepository perfilRepository;

    public AlergiaService(AlergiaRepository alergiaRepository, PerfilRepository perfilRepository){
        this.alergiaRepository=alergiaRepository;
        this.perfilRepository=perfilRepository;
    }

    public List<AlergiaRespuestaDTO> listarAlergias() {
        List<Alergia> alergias = alergiaRepository.findAll();
        List<AlergiaRespuestaDTO> respuesta = new ArrayList<>();
        for (Alergia alergia : alergias) {
            AlergiaRespuestaDTO dto = new AlergiaRespuestaDTO(
                alergia.getId(),
                alergia.getNombre(),
                alergia.getDescripcion()
            );

            respuesta.add(dto);
        }

        return respuesta;
    }

    public AlergiaRespuestaDTO añadirAlergia(Long usuarioId, Long alergiaId){
        Perfil perfil = perfilRepository.findByUsuarioId(usuarioId).orElseThrow(() -> new PerfilNoEncontradoException(usuarioId));
        Alergia alergia = alergiaRepository.findById(alergiaId).orElseThrow(() -> new AlergiaNoEncontradaException(alergiaId));
        perfil.agregarAlergia(alergia);
        perfilRepository.save(perfil);

        return new AlergiaRespuestaDTO(alergia.getId(),alergia.getNombre(),alergia.getDescripcion());
    }
    
}
