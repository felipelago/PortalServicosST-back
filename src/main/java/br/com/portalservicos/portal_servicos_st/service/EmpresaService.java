package br.com.portalservicos.portal_servicos_st.service;

import br.com.portalservicos.portal_servicos_st.dto.EmpresaEstrangeiraRequestDTO;
import br.com.portalservicos.portal_servicos_st.dto.EmpresaFisicaRequestDTO;
import br.com.portalservicos.portal_servicos_st.dto.EmpresaJuridicaRequestDTO;
import br.com.portalservicos.portal_servicos_st.entity.Empresa;
import br.com.portalservicos.portal_servicos_st.entity.Usuario;
import br.com.portalservicos.portal_servicos_st.enums.Permissoes;
import br.com.portalservicos.portal_servicos_st.enums.StatusEmpresa;
import br.com.portalservicos.portal_servicos_st.enums.TipoPessoa;
import br.com.portalservicos.portal_servicos_st.repository.EmpresaRepository;
import br.com.portalservicos.portal_servicos_st.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpresaService {
    private final EmpresaRepository empresaRepository;
    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Empresa cadastrarEmpresaJuridica(EmpresaJuridicaRequestDTO dto) {
        if (empresaRepository.findByCnpj(dto.cnpj()).isPresent()) {
            throw new RuntimeException("CNPJ já cadastrado!");
        }

        Empresa empresa = new Empresa();
        empresa.setTipoPessoa(TipoPessoa.JURIDICA);
        empresa.setRazaoSocial(dto.razaoSocial());
        empresa.setCnpj(dto.cnpj());
        empresa.setNomeFantasia(dto.nomeFantasia());
        empresa.setPerfil(dto.perfil());

        definirUsuarioResponsavelEStatus(empresa, dto.usuarioResponsavelId());

        return empresaRepository.save(empresa);
    }

    @Transactional
    public Empresa cadastrarEmpresaFisica(EmpresaFisicaRequestDTO dto) {
        if (empresaRepository.findByCpf(dto.cpf()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado!");
        }

        Empresa empresa = new Empresa();
        empresa.setTipoPessoa(TipoPessoa.FISICA);
        empresa.setNome(dto.nome());
        empresa.setCpf(dto.cpf());
        empresa.setNomeFantasia(dto.nomeFantasia());
        empresa.setPerfil(dto.perfil());

        definirUsuarioResponsavelEStatus(empresa, dto.usuarioResponsavelId());

        return empresaRepository.save(empresa);
    }

    @Transactional
    public Empresa cadastrarEmpresaEstrangeira(EmpresaEstrangeiraRequestDTO dto) {
        if (empresaRepository.findByIdentificadorEstrangeiro(dto.identificadorEstrangeiro()).isPresent()) {
            throw new RuntimeException("Identificador Estrangeiro já cadastrado!");
        }

        Empresa empresa = new Empresa();
        empresa.setTipoPessoa(TipoPessoa.ESTRANGEIRA);
        empresa.setRazaoSocial(dto.razaoSocial());
        empresa.setIdentificadorEstrangeiro(dto.identificadorEstrangeiro());
        empresa.setNomeFantasia(dto.nomeFantasia());
        empresa.setPerfil(dto.perfil());

        definirUsuarioResponsavelEStatus(empresa, dto.usuarioResponsavelId());

        return empresaRepository.save(empresa);
    }

    private void definirUsuarioResponsavelEStatus(Empresa empresa, Long usuarioResponsavelId) {
        Usuario usuario = usuarioRepository.findById(usuarioResponsavelId)
                .orElseThrow(() -> new RuntimeException("Usuário responsável não encontrado"));
        if (usuario.getPermissao() == Permissoes.EMPRESA_CADASTRO) {
            empresa.setStatus(StatusEmpresa.PENDENTE);
            empresa.setUsuarioResponsavel(usuario);
        } else {
            empresa.setStatus(StatusEmpresa.APROVADO);
            Usuario usuarioExterno = usuarioRepository.findById(usuarioResponsavelId)
                    .orElseThrow(() -> new RuntimeException("Usuário responsável não encontrado"));
            if (usuarioExterno.getPermissao() != Permissoes.EMPRESA_CADASTRO) {
                throw new RuntimeException("O usuário responsável deve ser um usuário externo.");
            }
            empresa.setUsuarioResponsavel(usuarioExterno);
        }
    }

    public List<Empresa> listarTodasEmpresas() {
        return empresaRepository.findAll();
    }
}
