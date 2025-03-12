package br.com.portalservicos.portal_servicos_st.controller;

import br.com.portalservicos.portal_servicos_st.dto.UsuarioRequestDTO;
import br.com.portalservicos.portal_servicos_st.dto.UsuarioResponseDTO;
import br.com.portalservicos.portal_servicos_st.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioResponseDTO> cadastrar(@RequestBody @Valid UsuarioRequestDTO usuarioDTO) {
        UsuarioResponseDTO usuarioCadastrado = usuarioService.cadastrarUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCadastrado);

    }

//    @GetMapping
//    public ResponseEntity<List<UsuarioResponseDTO>> listar() {
//        List<UsuarioResponseDTO> usuarios = usuarioService.listarUsuarios();
//        return ResponseEntity.ok(usuarios);
//    }
}
