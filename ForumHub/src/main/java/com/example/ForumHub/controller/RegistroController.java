package com.example.ForumHub.controller;

import com.example.ForumHub.dto.RegistroDto;
import com.example.ForumHub.entities.Usuario;
import com.example.ForumHub.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class RegistroController {

    @Autowired
    private UsuarioService usuarioService;

    // Endpoint de registro
    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@RequestBody RegistroDto registroDto) {
        try {
            // Criar o objeto Usuario a partir do DTO
            Usuario usuario = new Usuario();
            usuario.setEmail(registroDto.email());
            usuario.setSenha(registroDto.senha());

            // Chama o serviço de criação de usuário
            Usuario usuarioCriado = usuarioService.criarUsuario(usuario);

            // Retorna uma resposta de sucesso
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário registrado com sucesso.");
        } catch (Exception e) {
            // Em caso de erro (como e-mail já registrado)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao registrar usuário: " + e.getMessage());
        }
    }
}
