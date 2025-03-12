package br.com.portalservicos.portal_servicos_st.entity;

import br.com.portalservicos.portal_servicos_st.enums.StatusEmpresa;
import br.com.portalservicos.portal_servicos_st.enums.TipoPessoa;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "empresas")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    @Column
    private String razaoSocial;

    @Column
    private String nome;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String cnpj;

    @Column
    private String identificadorEstrangeiro;

    @Column
    private String nomeFantasia;

    @Column
    private String perfil;

    @Column
    private StatusEmpresa status = StatusEmpresa.PENDENTE;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioResponsavel;
}
