package backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.entity.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    boolean existsByUsuarioId(Long usuarioId);
}
