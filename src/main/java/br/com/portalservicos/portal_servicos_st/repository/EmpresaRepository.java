package br.com.portalservicos.portal_servicos_st.repository;

import br.com.portalservicos.portal_servicos_st.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Optional<Object> findByCnpj(String cnpj);

    Optional<Object> findByCpf(String cpf);

    Optional<Empresa> findByIdentificadorEstrangeiro(String identificadorEstrangeiro);

}
