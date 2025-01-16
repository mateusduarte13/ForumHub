package com.example.ForumHub.controller;

import com.example.ForumHub.entities.Topico;
import com.example.ForumHub.services.TopicoService;
import com.example.ForumHub.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")  // Define o endpoint base para os tópicos
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private TokenService tokenService;

    // Endpoint para listar todos os tópicos
    @GetMapping
    public List<Topico> listarTopicos() {
        return topicoService.listarTopicos();  // Chama o serviço para listar tópicos
    }

    // Endpoint para criar um novo tópico
    @PostMapping
    public Topico criarTopico(@RequestBody Topico topico) {
        return topicoService.criarTopico(topico);  // Chama o serviço para criar o tópico
    }

    // Endpoint para buscar um tópico pelo ID
    @GetMapping("/{id}")
    public Topico buscarTopicoPorId(@PathVariable Long id) {
        Optional<Topico> topicoOptional = topicoService.buscarTopicoPorId(id);
        return topicoOptional.orElse(null);  // Retorna o tópico se encontrado, ou null se não encontrado
    }

    // Endpoint para excluir um tópico
    @DeleteMapping("/{id}")
    public String excluirTopico(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        // Verifica se o token é válido
        try {
            String email = tokenService.getSujeito(token.replace("Bearer ", ""));

            Optional<Topico> topicoOptional = topicoService.buscarTopicoPorId(id);
            if (topicoOptional.isPresent()) {
                // Exclui o tópico
                topicoService.excluirTopico(id);
                return "Tópico excluído com sucesso!";
            } else {
                return "Tópico não encontrado.";
            }
        } catch (Exception e) {
            return "Token inválido ou expirado.";
        }
    }
}
