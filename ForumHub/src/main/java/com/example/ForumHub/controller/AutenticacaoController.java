package com.example.ForumHub.controller;

import com.example.ForumHub.dto.LoginDto;
import com.example.ForumHub.entities.Usuario;
import com.example.ForumHub.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody LoginDto loginDto) {
        // Usando os métodos gerados pelo record
        var dadosLogin = new UsernamePasswordAuthenticationToken(loginDto.email(), loginDto.senha());

        try {
            // Autentica usando o AuthenticationManager
            Authentication authentication = authenticationManager.authenticate(dadosLogin);

            // Pega o usuário autenticado
            Usuario usuario = (Usuario) authentication.getPrincipal();

            // Gera o token
            String token = tokenService.gerarToken(usuario);

            return ResponseEntity.ok().body(new TokenResponse(token));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }
    }

    // DTO interno para resposta com o token
    private static class TokenResponse {
        private String token;

        public TokenResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
