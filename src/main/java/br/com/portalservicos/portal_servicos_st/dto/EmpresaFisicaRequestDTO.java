package br.com.portalservicos.portal_servicos_st.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public record EmpresaFisicaRequestDTO(
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotBlank(message = "CPF é obrigatório")
        @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos numéricos")
        String cpf,

        @NotBlank(message = "Nome Fantasia é obrigatório")
        String nomeFantasia,

        @NotBlank(message = "Perfil é obrigatório")
        String perfil,

        Long usuarioResponsavelId
) {
}
