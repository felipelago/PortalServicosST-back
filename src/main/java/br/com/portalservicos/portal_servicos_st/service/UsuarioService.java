package br.com.portalservicos.portal_servicos_st.service;

import br.com.portalservicos.portal_servicos_st.dto.UsuarioRequestDTO;
import br.com.portalservicos.portal_servicos_st.dto.UsuarioResponseDTO;
import br.com.portalservicos.portal_servicos_st.entity.Usuario;
import br.com.portalservicos.portal_servicos_st.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UsuarioResponseDTO cadastrarUsuario(UsuarioRequestDTO dto) {
        if (usuarioRepository.findByEmail(dto.email()).isPresent()) {
            throw new RuntimeException("Email já cadastrado!");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(passwordEncoder.encode(dto.senha())); // Criptografando a senha
        usuario.setPermissao(dto.permissao());

        usuario = usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getPermissao());
    }

//    public List<UsuarioResponseDTO> listarUsuarios() {
//        return usuarioRepository.findAll();
//    }
}
