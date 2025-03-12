package br.com.portalservicos.portal_servicos_st.dto;

import br.com.portalservicos.portal_servicos_st.enums.Permissoes;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record UsuarioRequestDTO(
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @Email(message = "Email inválido")
        @NotBlank(message = "Email é obrigatório")
        String email,

        @NotBlank(message = "Senha é obrigatória")
        String senha,

        @NotNull(message = "Permissão é obrigatória")
        Permissoes permissao
) {}

