package br.com.portalservicos.portal_servicos_st.dto;

import jakarta.validation.constraints.NotBlank;

public record EmpresaEstrangeiraRequestDTO(
        @NotBlank(message = "Razão Social é obrigatória")
        String razaoSocial,

        @NotBlank(message = "Identificador Estrangeiro é obrigatório")
        String identificadorEstrangeiro,

        @NotBlank(message = "Nome Fantasia é obrigatório")
        String nomeFantasia,

        @NotBlank(message = "Perfil é obrigatório")
        String perfil,

        Long usuarioResponsavelId
) {
}