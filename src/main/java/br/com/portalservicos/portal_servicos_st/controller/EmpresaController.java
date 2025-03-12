package br.com.portalservicos.portal_servicos_st.controller;

import br.com.portalservicos.portal_servicos_st.dto.EmpresaEstrangeiraRequestDTO;
import br.com.portalservicos.portal_servicos_st.dto.EmpresaFisicaRequestDTO;
import br.com.portalservicos.portal_servicos_st.dto.EmpresaJuridicaRequestDTO;
import br.com.portalservicos.portal_servicos_st.entity.Empresa;
import br.com.portalservicos.portal_servicos_st.entity.Usuario;
import br.com.portalservicos.portal_servicos_st.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    @PostMapping("/cadastrar/juridica")
    public ResponseEntity<?> cadastrarEmpresaJuridica(
            @RequestBody @Valid EmpresaJuridicaRequestDTO empresaDTO,
            @AuthenticationPrincipal Usuario usuarioLogado) {

        Empresa empresaCriada = empresaService.cadastrarEmpresaJuridica(empresaDTO, usuarioLogado);
        return ResponseEntity.status(HttpStatus.CREATED).body("Empresa cadastrada com sucesso! ID: " + empresaCriada.getId());
    }

    @PostMapping("/cadastrar/fisica")
    public ResponseEntity<?> cadastrarEmpresaFisica(
            @RequestBody @Valid EmpresaFisicaRequestDTO empresaDTO,
            @AuthenticationPrincipal Usuario usuarioLogado) {
        empresaService.cadastrarEmpresaFisica(empresaDTO, usuarioLogado);
        return ResponseEntity.status(HttpStatus.CREATED).body("Empresa cadastrada com sucesso!");
    }

    @PostMapping("/cadastrar/estrangeira")
    public ResponseEntity<?> cadastrarEmpresaEstrangeira(
            @RequestBody @Valid EmpresaEstrangeiraRequestDTO empresaDTO,
            @AuthenticationPrincipal Usuario usuarioLogado) {
        empresaService.cadastrarEmpresaEstrangeira(empresaDTO, usuarioLogado);
        return ResponseEntity.status(HttpStatus.CREATED).body("Empresa cadastrada!");
    }
}
