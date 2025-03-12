package br.com.portalservicos.portal_servicos_st.dto;

import br.com.portalservicos.portal_servicos_st.enums.Permissoes;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email,
        Permissoes permissao
) {}

