package br.com.portalservicos.portal_servicos_st.controller;

import br.com.portalservicos.portal_servicos_st.dto.EmpresaEstrangeiraRequestDTO;
import br.com.portalservicos.portal_servicos_st.dto.EmpresaFisicaRequestDTO;
import br.com.portalservicos.portal_servicos_st.dto.EmpresaJuridicaRequestDTO;
import br.com.portalservicos.portal_servicos_st.entity.Empresa;
import br.com.portalservicos.portal_servicos_st.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/empresas")
public class EmpresaController {

    private final EmpresaService empresaService;

    @PostMapping("/cadastrar/juridica")
    public ResponseEntity<?> cadastrarEmpresaJuridica(
            @RequestBody @Valid EmpresaJuridicaRequestDTO empresaDTO) {

        Empresa empresaCriada = empresaService.cadastrarEmpresaJuridica(empresaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Empresa cadastrada com sucesso! ID: " + empresaCriada.getId());
    }

    @PostMapping("/cadastrar/fisica")
    public ResponseEntity<?> cadastrarEmpresaFisica(
            @RequestBody @Valid EmpresaFisicaRequestDTO empresaDTO) {
        empresaService.cadastrarEmpresaFisica(empresaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Empresa cadastrada com sucesso!");
    }

    @PostMapping("/cadastrar/estrangeira")
    public ResponseEntity<?> cadastrarEmpresaEstrangeira(
            @RequestBody @Valid EmpresaEstrangeiraRequestDTO empresaDTO) {
        empresaService.cadastrarEmpresaEstrangeira(empresaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Empresa cadastrada!");
    }

    @GetMapping("/listarTudo")
    public List<Empresa> listarTudo() {
        return empresaService.listarTodasEmpresas();
    }
}
