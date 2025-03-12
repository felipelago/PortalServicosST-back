package br.com.portalservicos.portal_servicos_st.repository;

import br.com.portalservicos.portal_servicos_st.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
