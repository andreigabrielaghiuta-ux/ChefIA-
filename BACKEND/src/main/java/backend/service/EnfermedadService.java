package backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import backend.dto.EnfermedadRespuestaDTO;
import backend.entity.Enfermedad;
import backend.entity.Perfil;
import backend.exception.EnfermedadNoEncontradaException;
import backend.exception.PerfilNoEncontradoException;
import backend.repository.EnfermedadRepository;
import backend.repository.PerfilRepository;

@Service
public class EnfermedadService {

    private final EnfermedadRepository enfermedadRepository;
    private final PerfilRepository perfilRepository;
 
    public EnfermedadService(
            EnfermedadRepository enfermedadRepository,
            PerfilRepository perfilRepository) {

        this.enfermedadRepository = enfermedadRepository;
        this.perfilRepository = perfilRepository;
    }

    @Transactional(readOnly = true)
    public List<EnfermedadRespuestaDTO> listarEnfermedades() {
        List<Enfermedad> enfermedades = enfermedadRepository.findAll();
        List<EnfermedadRespuestaDTO> respuesta = new ArrayList<>();

        for (Enfermedad enfermedad : enfermedades) {
            EnfermedadRespuestaDTO dto = new EnfermedadRespuestaDTO(
                    enfermedad.getId(),
                    enfermedad.getNombre(),
                    enfermedad.getDescripcion()
            );

            respuesta.add(dto);
        }

        return respuesta;
    }

    @Transactional
    public EnfermedadRespuestaDTO añadirEnfermedad(
            Long usuarioId,
            Long enfermedadId) {

        Perfil perfil = perfilRepository.findByUsuarioId(usuarioId)
                .orElseThrow(() ->
                        new PerfilNoEncontradoException(usuarioId));

        Enfermedad enfermedad = enfermedadRepository.findById(enfermedadId)
                .orElseThrow(() ->
                        new EnfermedadNoEncontradaException(enfermedadId));

        perfil.agregarEnfermedad(enfermedad);
        perfilRepository.save(perfil);

        return convertirADTO(enfermedad);
    }

    @Transactional
    public EnfermedadRespuestaDTO eliminarEnfermedad(
            Long usuarioId,
            Long enfermedadId) {

        Perfil perfil = perfilRepository.findByUsuarioId(usuarioId)
                .orElseThrow(() ->
                        new PerfilNoEncontradoException(usuarioId));

        Enfermedad enfermedad = enfermedadRepository.findById(enfermedadId)
                .orElseThrow(() ->
                        new EnfermedadNoEncontradaException(enfermedadId));

        perfil.eliminarEnfermedad(enfermedad);
        perfilRepository.save(perfil);

        return convertirADTO(enfermedad);
    }

    @Transactional(readOnly = true)
    public List<EnfermedadRespuestaDTO> listarEnfermedadesUsuario(
            Long usuarioId) {

        Perfil perfil = perfilRepository.findByUsuarioId(usuarioId)
                .orElseThrow(() ->
                        new PerfilNoEncontradoException(usuarioId));

        Set<Enfermedad> enfermedades = perfil.getEnfermedades();
        List<EnfermedadRespuestaDTO> respuesta = new ArrayList<>();

        for (Enfermedad enfermedad : enfermedades) {
            respuesta.add(convertirADTO(enfermedad));
        }

        return respuesta;
    }

    private EnfermedadRespuestaDTO convertirADTO(Enfermedad enfermedad) {
        return new EnfermedadRespuestaDTO(
                enfermedad.getId(),
                enfermedad.getNombre(),
                enfermedad.getDescripcion()
        );
    }
}