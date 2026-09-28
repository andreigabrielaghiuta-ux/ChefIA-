package backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.entity.Perfil;


public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    boolean existsByUsuarioId(Long usuarioId);
    Optional<Perfil> findByUsuarioId(Long usuarioId);

}
