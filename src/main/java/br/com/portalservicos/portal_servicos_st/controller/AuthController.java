package br.com.portalservicos.portal_servicos_st.controller;

import br.com.portalservicos.portal_servicos_st.dto.LoginRequestDTO;
import br.com.portalservicos.portal_servicos_st.entity.Usuario;
import br.com.portalservicos.portal_servicos_st.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api/auth")
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(request.email());

        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Usuário não encontrado");
        }

        Usuario usuario = usuarioOpt.get();

        if (!passwordEncoder.matches(request.senha(), usuario.getSenha())) {
            return ResponseEntity.badRequest().body("Senha incorreta");
        }

        return ResponseEntity.ok("Login bem-sucedido");
    }
}