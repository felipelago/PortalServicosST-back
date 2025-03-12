package br.com.portalservicos.portal_servicos_st.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public record EmpresaJuridicaRequestDTO(

        @NotBlank(message = "Razão Social é obrigatório")
        String razaoSocial,

        @NotBlank(message = "CNPJ é obrigatório")
        @Pattern(regexp = "\\d{14}", message = "CNPJ deve conter 14 dígitos numéricos")
        String cnpj,

        @NotBlank(message = "Nome fantasia é obrigatório")
        String nomeFantasia,

        @NotBlank(message = "Perfil é obrigatório")
        String perfil,

        Long usuarioResponsavelId
) {
}
